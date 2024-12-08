package org.example.model;

import java.util.List;

public class Admin extends User {
    public int adminId;
    public static int count = 0;
    public List<User> assignedUsers;

    public Admin(String fName, String lName, String phoneNumber, String email) {
        super(fName, lName, phoneNumber, email);
        adminId = count++;
    }

    public Admin(int adminId, String fName, String lName, String phoneNumber, String email) {
        super(fName, lName, phoneNumber, email);
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }
}
