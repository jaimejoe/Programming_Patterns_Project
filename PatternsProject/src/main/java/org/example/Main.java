package org.example;

import org.example.controller.MainFrameController;
import org.example.model.Address;
import org.example.model.Admin;
import org.example.model.Customer;
import org.example.model.UserDriver;
import org.example.view.MainFrameForm;

import static org.example.controller.util.DatabaseUtil.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        createCustomersTable();
//        createAdminsTable();
//        createDriversTable();
//        createOrderTable();
//        createFoodItemTable();
//        Address address1 = new Address(123, "street", "Montreal", "Quebec", "123sdf");
//        Customer customer1 = new Customer("John", "Smith", "5141234567","asd@gmail.com", 200, address1);
//        Customer customer2 = new Customer("Max", "Verstappen", "7681235462","car@gmail.com", 200, address1);
//
//        Admin admin1 = new Admin("Sally", "Jones", "3216549876", "fds@gmail.com");
//
//        UserDriver driver1 = new UserDriver("Carlos", "Sainz", "5679876543", "poi@gmail.com");

//        insertRecordsCustomers(customer1);
//        insertRecordsCustomers(customer2);
//        insertRecordsAdmins(admin1);
//        insertRecordsDrivers(driver1);
       MainFrameForm view = new MainFrameForm();
       new MainFrameController(view);
    }
}