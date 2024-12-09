package org.example.view.customerview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerViewForm extends JFrame {
    private JPanel mainPanel;
    private JLabel customerOptionsLabel;
    private JButton orderButton;
    private JButton cancelOrderButton;
    private JButton viewOrdersButton;

    public CustomerViewForm() throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CustomerOrderForm orderForm = new CustomerOrderForm();
                orderForm.setVisible(true);
            }
        });
    }
}
