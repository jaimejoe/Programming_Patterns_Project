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

    public AdminMainForm(Admin admin){
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        viewOrdersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminViewOrders viewForm = new AdminViewOrders();
                viewForm.setVisible(true);
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminCancelOrderForm cancelForm = new AdminCancelOrderForm();
                cancelForm.setVisible(true);
            }
        });
        processBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminProcessOrderForm processForm = new AdminProcessOrderForm();
                processForm.setVisible(true);
            }
        });
    }
}
