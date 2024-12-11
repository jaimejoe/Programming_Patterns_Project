package org.example.controller.admincontroller;

import org.example.model.Admin;
import org.example.view.adminview.AdminMainForm;

public class AdminMainFormController {
    public AdminMainForm adminMainForm;
    public Admin admin;

    public AdminMainFormController(AdminMainForm adminMainForm, Admin admin) {
        this.adminMainForm = adminMainForm;
        this.admin = admin;
        adminMainForm.setVisible(true);
    }
}
