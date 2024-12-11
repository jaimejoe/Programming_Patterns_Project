package org.example.view.adminview;

import org.example.model.Admin;
import org.example.view.customerview.CustomerViewForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainForm extends JFrame{
    private JLabel titleLabel;
    private JButton processBtn;
    private JButton cancelBtn;
    private JButton viewOrdersBtn;
    private JPanel mainPanel;

    public AdminMainForm(Admin admin) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JButton getProcessBtn() {
        return processBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public JButton getViewOrdersBtn() {
        return viewOrdersBtn;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
