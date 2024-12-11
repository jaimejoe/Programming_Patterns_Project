package org.example.controller.customercontroller;

import org.example.controller.admincontroller.AdminMainFormController;
import org.example.controller.util.DatabaseUtil;
import org.example.model.Customer;
import org.example.view.adminview.AdminMainForm;
import org.example.view.customerview.CustomerCancelForm;
import org.example.view.customerview.CustomerMainForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerCancelOrderController {
    public CustomerCancelForm form;
    public Customer customer;

    public CustomerCancelOrderController(CustomerCancelForm form, Customer customer) {
        this.form = form;
        this.customer = customer;
        form.setVisible(true);


//        When cancel button pressed, order removed from orders table
        form.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderIdText = form.getIdTextField().getText();
                try {
                    int orderId = Integer.parseInt(orderIdText);
                    DatabaseUtil.deleteOrder(orderId);
                    JOptionPane.showMessageDialog(form.getMainPanel(), "Order cancelled.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(form.getMainPanel(), "Please enter a valid order ID.");
                }
            }
        });

        form.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                CustomerMainFormController newForm = new CustomerMainFormController(new CustomerMainForm(customer),customer);
            }
        });
    }
}
