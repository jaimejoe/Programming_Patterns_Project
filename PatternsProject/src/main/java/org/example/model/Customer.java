package org.example.model;

public class Customer extends User{
    public Address address;
    public double balance;

    public Customer(String fName, String lName, String phoneNumber, String email, double balance,Address address) {
        super(fName, lName, phoneNumber, email);
        this.address = address;
        this.balance = balance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
