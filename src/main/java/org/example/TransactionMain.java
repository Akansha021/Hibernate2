package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionMain {

    public static Transaction save(Session session,Person person) throws TransactionException{
        Transaction trans = session.beginTransaction();
        session.save(person);
//        session.save(account);


        if(person.getAccount()==null){
            trans.rollback();
//                throw new TransactionException(trans,"Account does not exist for person");
        }
        return trans;
    }
    public static void main(String[] args) throws TransactionException {
        Configuration con= new Configuration();
        con.configure();
        SessionFactory sessionFactory=con.buildSessionFactory();
        Session session1=sessionFactory.openSession();
        Account account1 = new Account("Saving", 1005);
        Person person1 = new Person("Xtyi", "Vietnam");

//        person1.setAccount(account1);
//        Transaction trans=
        try {
            save(session1,person1);
        }catch (TransactionException e){
            System.out.println(e);
        }catch (Exception e1){
            System.out.println(e1);
        }

        session1.close();


    }
}
