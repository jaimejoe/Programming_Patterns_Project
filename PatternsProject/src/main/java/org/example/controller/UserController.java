package org.example.controller;

import org.example.controller.util.DatabaseUtil;
import org.example.model.*;
import org.example.view.MainFrameForm;

import static org.example.controller.util.DatabaseUtil.*;
import static org.example.controller.util.DatabaseUtil.insertRecordsDrivers;

public class UserController {
    MainFrameForm mainFrameForm;

    public UserController() {
        createCustomersTable();
        createAdminsTable();
        createDriversTable();
        createOrderTable();
        createFoodItemTable();

    }

    public void insertSampleRecords() {
        Address address1 = new Address(123, "street", "Montreal", "Quebec", "123sdf");
        Customer customer1 = new Customer("John", "Smith", "5141234567","asd@gmail.com", 200, address1);
        Customer customer2 = new Customer("Max", "Verstappen", "7681235462","car@gmail.com", 200, address1);
        Admin admin1 = new Admin("Sally", "Jones", "3216549876", "fds@gmail.com");
        UserDriver driver1 = new UserDriver("Carlos", "Sainz", "5679876543", "poi@gmail.com");

        insertRecordsCustomers(customer1);
        insertRecordsCustomers(customer2);
        insertRecordsAdmins(admin1);
        insertRecordsDrivers(driver1);
    }

    public void init() {
        mainFrameForm = new MainFrameForm();
    }
}
