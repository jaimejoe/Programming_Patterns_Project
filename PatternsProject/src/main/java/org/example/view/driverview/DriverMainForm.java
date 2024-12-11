package org.example.view.driverview;

import org.example.model.UserDriver;
import org.example.view.customerview.CustomerViewForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMainForm extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JButton deliverButton;

    public DriverMainForm(UserDriver userDriver) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        deliverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DriverDeliverForm deliverForm = new DriverDeliverForm(userDriver);
                deliverForm.setVisible(true);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JButton getDeliverButton() {
        return deliverButton;
    }
}
