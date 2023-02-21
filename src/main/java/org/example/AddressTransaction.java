package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AddressTransaction {

    @Id
    private int id;
    private String address;

    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name="person_id")
    PersonTransaction personTransaction;

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonTransaction getPersonTransaction() {
        return personTransaction;
    }

    public void setPersonTransaction(PersonTransaction personTransaction) {
        this.personTransaction = personTransaction;
    }
}
