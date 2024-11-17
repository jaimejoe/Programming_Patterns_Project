package org.example.model;

public abstract class User {
    public int id;
    public String fName;
    public String lName;
    public String phoneNumber;
    public String email;

    public User(String fName, String lName, String phoneNumber, String email) {
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        int count = 0;
        this.id = count++;
    }
}
