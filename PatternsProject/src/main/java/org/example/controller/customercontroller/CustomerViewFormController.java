package org.example.controller.customercontroller;

import org.example.model.Customer;
import org.example.view.customerview.CustomerViewForm;

public class CustomerViewFormController {
    public CustomerViewForm customerViewForm;
    public Customer customer;

    public CustomerViewFormController(CustomerViewForm customerViewForm, Customer customer) {
        this.customerViewForm = customerViewForm;
        this.customer = customer;
        customerViewForm.setVisible(true);
    }
}
