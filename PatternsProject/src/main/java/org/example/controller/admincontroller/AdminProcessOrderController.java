package org.example.controller.admincontroller;

import org.example.model.Admin;
import org.example.view.adminview.AdminProcessOrderForm;

public class AdminProcessOrderController {
    public AdminProcessOrderForm form;
    public Admin admin;

    public AdminProcessOrderController(AdminProcessOrderForm form, Admin admin) {
        this.form = form;
        this.admin = admin;
        form.setVisible(true);
    }
}
