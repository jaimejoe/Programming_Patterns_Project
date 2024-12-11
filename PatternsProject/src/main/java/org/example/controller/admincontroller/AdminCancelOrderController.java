package org.example.controller.admincontroller;

import org.example.model.Admin;
import org.example.view.adminview.AdminCancelOrderForm;

public class AdminCancelOrderController {
    public AdminCancelOrderForm form;
    public Admin admin;

    public AdminCancelOrderController(AdminCancelOrderForm form, Admin admin) {
        this.form = form;
        this.admin = admin;
        form.setVisible(true);
    }
}
