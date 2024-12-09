package org.example.model;

public class Customer extends User{
    public Address address;
    public String addressString;
    public double balance;
    public int customerId;
    public static int count = 1;

    public Customer(String fName, String lName, String phoneNumber, String email, double balance, Address address) {
        super(fName, lName, phoneNumber, email);
        this.address = address;
        this.balance = balance;
        customerId = count++;
    }

    public Customer(int customerId, String fName, String lName, String phoneNumber, String email, double balance, String address) {
        super(fName, lName, phoneNumber, email);
        this.addressString = address;
        this.balance = balance;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
