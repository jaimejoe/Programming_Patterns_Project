package org.example.controller.admincontroller;

import org.example.model.Admin;
import org.example.view.adminview.AdminMainForm;
import org.example.view.adminview.AdminViewOrders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminViewFormController {
    public AdminViewOrders form;
    public Admin admin;

    public AdminViewFormController(AdminViewOrders form, Admin admin) {
        this.form = form;
        this.admin = admin;
        form.setVisible(true);

        form.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                AdminMainFormController newForm = new AdminMainFormController(new AdminMainForm(admin),admin);
            }
        });
    }
}
