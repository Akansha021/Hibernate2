package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Merge {
    public static void main(String[] args) {
        Account account1=null;
        Account account2=null;
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();

        account1=session.get(Account.class,1);
        System.out.println(account1);
        session.close();

//        account1.setNumber(2);
        account1.setName("Ziop");
        Session session1=sessionFactory.openSession();

        account2=session1.get(Account.class,1);
        session1.beginTransaction();

        //if same data in database is loaded(using get) with different object name and there is different session for both the object
        // then when session is closed for first object ,we want to update it with second session in that case we should use merge
        //instead of update as when session is closed object gets detached, so it does not identify the update of first object,
        //and therefore it throws exception

        session1.merge(account1);

        session1.getTransaction().commit();
        System.out.println(account2);

        session.close();

    }
}
