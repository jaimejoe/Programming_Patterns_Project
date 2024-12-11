package org.example.view.customerview;

import org.example.model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainForm extends JFrame {
    private JPanel mainPanel;
    private JLabel customerOptionsLabel;
    private JButton orderButton;
    private JButton cancelOrderButton;
    private JButton viewOrdersButton;

    public CustomerMainForm(Customer customer) throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CustomerOrderForm orderForm = new CustomerOrderForm(customer);
                orderForm.setVisible(true);
            }
        });
        cancelOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CustomerCancelForm cancelForm = new CustomerCancelForm(customer);
                cancelForm.setVisible(true);
            }
        });
        viewOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CustomerViewForm viewForm = new CustomerViewForm(customer);
                viewForm.setVisible(true);
            }
        });
    }
}
