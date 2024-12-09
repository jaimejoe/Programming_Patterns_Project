package org.example.view;

import org.example.view.adminview.*;
import org.example.view.customerview.*;
import org.example.view.driverview.DriverViewForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameForm extends JFrame {
    private JButton customerButton;
    private JButton adminButton;
    private JButton driverButton;
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton submitButton1;
    private JTextField textField2;
    private JButton submitButton2;
    private JTextField textField3;
    private JButton submitButton3;

    public MainFrameForm() throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameForm.this.dispose();
                new CustomerViewForm().setVisible(true);
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminViewForm().setVisible(true);
            }
        });
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DriverViewForm().setVisible(true);
            }
        });
    }
}
