package org.example;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration conf=new Configuration();
        conf.configure();
        SessionFactory sessionFactory= conf.buildSessionFactory();
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            TypedQuery query=session.getNamedQuery("findNamedQueryByName");
//            transaction=session.beginTransaction();
            query.setParameter("name","Jim");
//            transaction.commit();

            List<Object[]>objects=query.getResultList();

            for (Object[] obj:objects) {
                System.out.println(Arrays.toString(obj));
            }

        }catch (Exception e){
            if (transaction != null) {
//                transaction.rollback();
            }
        }


//        NativeQuery query= (NativeQuery) session.createQuery("select * from student");
//
////        Query query1=session.createQuery("select s.id,s.name,c.id,c.name from Student s INNER JOIN Courses c on c.student=s.id");
//        List<Object[]> listObject1=query.list();
//
//        System.out.println("INNER JOIN: ");
//        for (Object[] obj:listObject1) {
//            System.out.println(Arrays.toString(obj));
//        }



    }
}