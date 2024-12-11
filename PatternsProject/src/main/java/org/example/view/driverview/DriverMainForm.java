package org.example.view.driverview;

import org.example.model.UserDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMainForm extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JButton deliverButton;
    private JButton backButton;

    public DriverMainForm(UserDriver userDriver) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    public JButton getBackButton() {
        return backButton;
    }
}
