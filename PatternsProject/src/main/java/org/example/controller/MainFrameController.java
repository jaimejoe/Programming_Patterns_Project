package org.example.controller;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Admin;
import org.example.model.Customer;
import org.example.model.UserDriver;
import org.example.view.MainFrameForm;
import org.example.view.adminview.AdminMainForm;
import org.example.view.customerview.CustomerMainForm;
import org.example.view.driverview.DriverMainForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static org.example.controller.util.DatabaseUtil.*;
import static org.example.controller.util.DatabaseUtil.insertRecordsDrivers;

public class MainFrameController {
    MainFrameForm mainFrameForm;

    public MainFrameController(MainFrameForm mainFrameForm) {
        createCustomersTable();
        createAdminsTable();
        createDriversTable();
        createOrderTable();
        createFoodItemTable();
        this.mainFrameForm = mainFrameForm;
        mainFrameForm.setVisible(true);
        this.mainFrameForm.getCustomerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                MainFrameForm.this.dispose();
//                new CustomerViewForm().setVisible(true);
                mainFrameForm.getCustomerTextField().setVisible(true);
                mainFrameForm.getSubmitButton1().setVisible(true);
            }
        });

        this.mainFrameForm.getAdminButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new AdminViewForm().setVisible(true);
                mainFrameForm.getAdminTextField().setVisible(true);
                mainFrameForm.getSubmitButton2().setVisible(true);
            }
        });
        this.mainFrameForm.getDriverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new DriverViewForm().setVisible(true);
                mainFrameForm.getDriverTextField().setVisible(true);
                mainFrameForm.getSubmitButton3().setVisible(true);
            }
        });

        mainFrameForm.getSubmitButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Customer> customers = DatabaseUtil.queryAllCustomers();
                for (Customer customer : customers) {
                    if (customer.getCustomerId() == Integer.parseInt(mainFrameForm.getCustomerTextField().getText())) {
                        new CustomerMainForm(customer);
                        mainFrameForm.dispose();
                        return;
                    }
                }
            }
        });
        mainFrameForm.getSubmitButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Admin> admins = DatabaseUtil.queryAllAdmins();
                for (Admin admin : admins) {
                    if (admin.getAdminId() == Integer.parseInt(mainFrameForm.getAdminTextField().getText())) {
                        new AdminMainForm(admin);
                        mainFrameForm.dispose();
                        return;
                    }
                }
            }
        });
        mainFrameForm.getSubmitButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<UserDriver> drivers = DatabaseUtil.queryAllDrivers();
                for (UserDriver driver : drivers) {
                    if (driver.driverId == Integer.parseInt(mainFrameForm.getDriverTextField().getText())) {
                        new DriverMainForm(driver);
                        mainFrameForm.dispose();
                        return;
                    }
                }
            }
        });
    }
}
