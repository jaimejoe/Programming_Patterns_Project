package org.example.model;

import java.util.List;

public class Admin extends User {
    public List<User> assignedUsers;

    public Admin(String fName, String lName, String phoneNumber, String email) {
        super(fName, lName, phoneNumber, email);
    }

}
