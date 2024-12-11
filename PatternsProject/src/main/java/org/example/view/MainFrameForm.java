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
import org.example.model.UserDriver;
import org.example.view.adminview.AdminMainForm;
import org.example.view.customerview.CustomerMainForm;
import org.example.view.driverview.DriverMainForm;

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
    }

    public JButton getCustomerButton() {
        return customerButton;
    }

    public JButton getAdminButton() {
        return adminButton;
    }

    public JButton getDriverButton() {
        return driverButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getCustomerTextField() {
        return customerTextField;
    }

    public JButton getSubmitButton1() {
        return submitButton1;
    }

    public JTextField getAdminTextField() {
        return adminTextField;
    }

    public JButton getSubmitButton2() {
        return submitButton2;
    }

    public JTextField getDriverTextField() {
        return driverTextField;
    }

    public JButton getSubmitButton3() {
        return submitButton3;
    }
}
