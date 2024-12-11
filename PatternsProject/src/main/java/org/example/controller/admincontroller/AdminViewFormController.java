package org.example.controller.admincontroller;

import org.example.model.Admin;
import org.example.view.adminview.AdminViewOrders;

public class AdminViewFormController {
    public AdminViewOrders adminViewOrders;
    public Admin admin;

    public AdminViewFormController(AdminViewOrders adminViewOrders, Admin admin) {
        this.adminViewOrders = adminViewOrders;
        this.admin = admin;
        adminViewOrders.setVisible(true);
    }
}
