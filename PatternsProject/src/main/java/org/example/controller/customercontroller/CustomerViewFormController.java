package org.example.controller.customercontroller;

import org.example.model.Customer;
import org.example.view.customerview.CustomerMainForm;
import org.example.view.customerview.CustomerViewForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerViewFormController {
    public CustomerViewForm customerViewForm;
    public Customer customer;

    public CustomerViewFormController(CustomerViewForm customerViewForm, Customer customer) {
        this.customerViewForm = customerViewForm;
        this.customer = customer;
        customerViewForm.setVisible(true);

        customerViewForm.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerViewForm.dispose();
                CustomerMainFormController newForm = new CustomerMainFormController(new CustomerMainForm(customer),customer);
            }
        });
    }
}
