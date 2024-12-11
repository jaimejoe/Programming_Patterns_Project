package org.example.controller.admincontroller;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Admin;
import org.example.view.adminview.AdminCancelOrderForm;
import org.example.view.adminview.AdminMainForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCancelOrderController {
    public AdminCancelOrderForm form;
    public Admin admin;

    public AdminCancelOrderController(AdminCancelOrderForm form, Admin admin) {
        this.form = form;
        this.admin = admin;
        form.setVisible(true);


//          When cancel button pressed, order removed from orders table
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
                AdminMainFormController newForm = new AdminMainFormController(new AdminMainForm(admin),admin);
            }
        });
    }
}
