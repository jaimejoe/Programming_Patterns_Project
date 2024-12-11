package org.example.controller;

import org.example.controller.admincontroller.AdminMainFormController;
import org.example.controller.customercontroller.CustomerMainFormController;
import org.example.controller.drivercontroller.DriverMainFormController;
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

public class MainFrameController {
    public MainFrameForm mainFrameForm;

    public MainFrameController(MainFrameForm mainFrameForm) {
        this.mainFrameForm = mainFrameForm;
        mainFrameForm.setVisible(true);

        // When customer button pressed, open to customer textfield
        mainFrameForm.getCustomerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameForm.getCustomerTextField().setVisible(true);
                mainFrameForm.getSubmitButton1().setVisible(true);
            }
        });

        //When Admin button pressed, open to admin textfield
        mainFrameForm.getAdminButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameForm.getAdminTextField().setVisible(true);
                mainFrameForm.getSubmitButton2().setVisible(true);
            }
        });
        //When Driver button pressed open to driver text field
        mainFrameForm.getDriverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrameForm.getDriverTextField().setVisible(true);
                mainFrameForm.getSubmitButton3().setVisible(true);
            }
        });
// When customer button pressed, send to CustomerMainForm
        mainFrameForm.getSubmitButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Customer> customers = DatabaseUtil.queryAllCustomers();
                for (Customer customer : customers) {
                    if (customer.getCustomerId() == Integer.parseInt(mainFrameForm.getCustomerTextField().getText())) {
                        new CustomerMainFormController(new CustomerMainForm(customer), customer);
                        mainFrameForm.dispose();
                    }
                }
            }
        });
        //When Admin button pressed, send to AdminMainForm
        mainFrameForm.getSubmitButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Admin> admins = DatabaseUtil.queryAllAdmins();
                for (Admin admin : admins) {
                    if (admin.getAdminId() == Integer.parseInt(mainFrameForm.getAdminTextField().getText())) {
                        new AdminMainFormController(new AdminMainForm(admin), admin);
                        mainFrameForm.dispose();
                    }
                }
            }
        });
        //When Driver button pressed send to DriverMainForm
        mainFrameForm.getSubmitButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<UserDriver> drivers = DatabaseUtil.queryAllDrivers();
                for (UserDriver driver : drivers) {
                    if (driver.driverId == Integer.parseInt(mainFrameForm.getDriverTextField().getText())) {
                        DriverMainForm driverMainForm = new DriverMainForm(driver);
                        DriverMainFormController driverMainFormController =
                                new DriverMainFormController(driverMainForm, driver);
                        mainFrameForm.dispose();
                    }
                }
            }
        });
    }
}
