package org.example.model;

public class Customer extends User{
    public String address;
    public double balance;
    public int customerId;
    public static int count = 1;

    public Customer(String fName, String lName, String phoneNumber, String email, double balance, Address address) {
        super(fName, lName, phoneNumber, email);
        this.address = address.toString();
        this.balance = balance;
        customerId = count++;
    }

    public Customer(int customerId, String fName, String lName, String phoneNumber, String email, String address, double balance) {
        super(fName, lName, phoneNumber, email);
        this.address = address;
        this.balance = balance;
        this.customerId = count++;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
