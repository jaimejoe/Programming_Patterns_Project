package org.example.controller.customercontroller;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Customer;
import org.example.view.customerview.CustomerCancelForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerCancelOrderController {
    public CustomerCancelForm customerCancelForm;
    public Customer customer;

    public CustomerCancelOrderController(CustomerCancelForm customerCancelForm, Customer customer) {
        this.customerCancelForm = customerCancelForm;
        this.customer = customer;
        customerCancelForm.setVisible(true);

        customerCancelForm.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderIdText = customerCancelForm.getIdTextField().getText();
                try {
                    int orderId = Integer.parseInt(orderIdText);
                    DatabaseUtil.deleteOrder(orderId);
                    JOptionPane.showMessageDialog(customerCancelForm.getMainPanel(), "Order cancelled.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(customerCancelForm.getMainPanel(), "Please enter a valid order ID.");
                }
            }
        });
    }
}
