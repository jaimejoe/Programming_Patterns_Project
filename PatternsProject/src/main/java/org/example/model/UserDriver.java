package org.example.model;

public class UserDriver extends User {
    public int driverId;
    public static int count = 0;

    public UserDriver(String fName, String lName, String phoneNumber, String email) {
        super(fName, lName, phoneNumber, email);
        driverId = count++;
    }

    public UserDriver(int driverId, String fName, String lName, String phoneNumber, String email) {
        super(fName, lName, phoneNumber, email);
        this.driverId = driverId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
