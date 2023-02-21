package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class SeparateTransaction {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session1= sessionFactory.openSession();

        Transaction t=session1.beginTransaction();

        AddressTransaction addressTransaction1=new AddressTransaction();
        addressTransaction1.setId(1);
        addressTransaction1.setAddress("Lagankhel");

        AddressTransaction addressTransaction2=new AddressTransaction();
        addressTransaction2.setId(2);
        addressTransaction2.setAddress("Suryabinayak");

        session1.saveOrUpdate(addressTransaction1);
        session1.saveOrUpdate(addressTransaction2);

        t.commit();
        session1.close();

        Session session2=sessionFactory.openSession();
        Transaction t1=session2.beginTransaction();

        List<AddressTransaction>addressTransactionList=new ArrayList<>();
        addressTransactionList.add(addressTransaction1);
        addressTransactionList.add(addressTransaction2);

        PersonTransaction personTransaction1=new PersonTransaction();
        personTransaction1.setId(1);
        personTransaction1.setName("ABC");
        personTransaction1.setAddressTransactionList(addressTransactionList);



        addressTransaction1.setPersonTransaction(personTransaction1);
        addressTransaction2.setPersonTransaction(personTransaction1);


        session2.saveOrUpdate(personTransaction1);
        session2.saveOrUpdate(addressTransaction1);
        session2.saveOrUpdate(addressTransaction2);

        t1.commit();

        session2.close();





    }
}
