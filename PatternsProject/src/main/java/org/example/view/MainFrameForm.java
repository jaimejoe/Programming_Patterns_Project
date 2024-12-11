package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.example.model.Admin;
import org.example.model.Customer;
import org.example.controller.util.DatabaseUtil;
import org.example.model.Order;
import org.example.view.adminview.AdminMainForm;
import org.example.view.customerview.CustomerMainForm;

public class MainFrameForm extends JFrame {
    private JButton customerButton;
    private JButton adminButton;
    private JButton driverButton;
    private JPanel mainPanel;
    private JTextField customerTextField;
    private JButton submitButton1;
    private JTextField adminTextField;
    private JButton submitButton2;
    private JTextField driverTextField;
    private JButton submitButton3;

    public MainFrameForm() throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerTextField.setVisible(false);
        adminTextField.setVisible(false);
        driverTextField.setVisible(false);
        submitButton1.setVisible(false);
        submitButton2.setVisible(false);
        submitButton3.setVisible(false);
        setVisible(true);
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                MainFrameForm.this.dispose();
//                new CustomerViewForm().setVisible(true);
                customerTextField.setVisible(true);
                submitButton1.setVisible(true);
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new AdminViewForm().setVisible(true);
                adminTextField.setVisible(true);
                submitButton2.setVisible(true);
            }
        });
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new DriverViewForm().setVisible(true);
                driverTextField.setVisible(true);
                submitButton3.setVisible(true);
            }
        });
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Customer> customers = DatabaseUtil.queryAllCustomers();
                for (Customer customer : customers) {
                    if (customer.getCustomerId() == Integer.parseInt(customerTextField.getText())) {
                        new CustomerMainForm(customer);
                        dispose();
                        return;
                    }
                }
            }
        });
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Admin> admins = DatabaseUtil.queryAllAdmins();
                for (Admin admin : admins) {
                    if (admin.getAdminId() == Integer.parseInt(adminTextField.getText())) {
                        new AdminMainForm(admin);
                        dispose();
                        return;
                    }
                }
            }
        });
    }
}
