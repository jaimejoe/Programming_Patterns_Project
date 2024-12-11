package org.example.controller.admincontroller;

import org.example.model.Admin;
import org.example.view.adminview.AdminCancelOrderForm;
import org.example.view.adminview.AdminMainForm;
import org.example.view.adminview.AdminProcessOrderForm;
import org.example.view.adminview.AdminViewOrders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainFormController {
    public AdminMainForm form;
    public Admin admin;

    public AdminMainFormController(AdminMainForm form, Admin admin) {
        this.form = form;
        this.admin = admin;
        form.setVisible(true);


//       when view orders button pressed, send to AdminViewForm

        form.getViewOrdersBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                AdminViewOrders viewForm = new AdminViewOrders();
                AdminViewFormController viewFormController = new AdminViewFormController(viewForm, admin);
            }
        });


        //When cancel button pressed, send to AdminCancelForm
        form.getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                AdminCancelOrderForm cancelForm = new AdminCancelOrderForm();
                AdminCancelOrderController cancelFormController = new AdminCancelOrderController(cancelForm, admin);
            }
        });
//        When process button pressed, send to AdminViewForm
        form.getProcessBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                AdminProcessOrderForm processForm = new AdminProcessOrderForm();
                AdminProcessOrderController processFormController = new AdminProcessOrderController(processForm, admin);
            }
        });
        form.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                AdminMainFormController newForm = new AdminMainFormController(new AdminMainForm(admin),admin);
            }
        });
    }
}
