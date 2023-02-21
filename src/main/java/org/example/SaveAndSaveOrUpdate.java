package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveAndSaveOrUpdate {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();

        Transaction t=session.beginTransaction();
        Account account=new Account("Anee",1234);
        //Tells that duplicate entry '2' for key 'PRIMARY'
        account.setId(2);
        account.setNumber(35665);
        account.setName("Crir");

        session.save(account);

        t.commit();
        session.close();

        Session session1=sessionFactory.openSession();
        Transaction t1=session1.beginTransaction();

        Account account1=new Account("Anee",1234);

        account1.setId(2);
        account1.setNumber(35665);
        account1.setName("Crir");

        session1.saveOrUpdate(account1);
    //saveOrUpdate updates the value of the given object even if object already exists in database but in case of save it does not update, and it gives exception duplicate entry
        t1.commit();
        session1.close();

    }


}
