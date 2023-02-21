package org.example;

import org.hibernate.Transaction;

public class TransactionException extends Exception{
    TransactionException(Transaction t,String cause){
        System.out.println(cause);
//        t.rollback();

    }
}
