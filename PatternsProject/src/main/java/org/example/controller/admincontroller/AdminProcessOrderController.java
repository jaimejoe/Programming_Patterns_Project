package org.example.controller.admincontroller;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Admin;
import org.example.view.adminview.AdminMainForm;
import org.example.view.adminview.AdminProcessOrderForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProcessOrderController {
    public AdminProcessOrderForm form;
    public Admin admin;

    public AdminProcessOrderController(AdminProcessOrderForm form, Admin admin) {
        this.form = form;
        this.admin = admin;
        form.setVisible(true);

//        When process button pressed with corresponding id in textfield, change order status to "Processed"
        form.getProcessButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderIdText = form.getIdTextField().getText();
                try {
                    int orderId = Integer.parseInt(orderIdText);
                    DatabaseUtil.updateOrderStatus(orderId, "Processed");
                    JOptionPane.showMessageDialog(form.getMainPanel(), "Order Processed.");
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
