package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class PersonTransaction {
    @Id
    private int id;
    private String name;

    @OneToMany(targetEntity = AddressTransaction.class,mappedBy = "personTransaction")
    List<AddressTransaction>addressTransactionList;

    public List<AddressTransaction> getAddressTransactionList() {
        return addressTransactionList;
    }

    public void setAddressTransactionList(List<AddressTransaction> addressTransactionList) {
        this.addressTransactionList = addressTransactionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
