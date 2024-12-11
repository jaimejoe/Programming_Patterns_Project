package org.example.controller.customercontroller;

import org.example.model.Customer;
import org.example.view.customerview.CustomerCancelForm;
import org.example.view.customerview.CustomerMainForm;
import org.example.view.customerview.CustomerOrderForm;
import org.example.view.customerview.CustomerViewForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainFormController {
    public CustomerMainForm customerMainForm;
    public Customer customer;

    public CustomerMainFormController(CustomerMainForm customerMainForm, Customer customer) {
        this.customerMainForm = customerMainForm;
        this.customer = customer;
        customerMainForm.setVisible(true);

        customerMainForm.getOrderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerMainForm.dispose();
                CustomerOrderForm orderForm = new CustomerOrderForm(customer);
                new CustomerOrderFormController(orderForm, customer);
            }
        });
        customerMainForm.getCancelOrderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerMainForm.dispose();
                CustomerCancelForm cancelForm = new CustomerCancelForm(customer);
                new CustomerCancelOrderController(cancelForm, customer);
            }
        });
        customerMainForm.getViewOrdersButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerMainForm.dispose();
                CustomerViewForm viewForm = new CustomerViewForm(customer);
                new CustomerViewFormController(viewForm, customer);
            }
        });
    }
}
