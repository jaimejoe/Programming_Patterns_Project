package org.example.controller.drivercontroller;

import org.example.controller.customercontroller.CustomerMainFormController;
import org.example.controller.util.DatabaseUtil;
import org.example.model.UserDriver;
import org.example.view.customerview.CustomerMainForm;
import org.example.view.driverview.DriverDeliverForm;
import org.example.view.driverview.DriverMainForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverDeliverController {
    public DriverDeliverForm form;
    public UserDriver driver;
    public DriverDeliverController(DriverDeliverForm form, UserDriver driver) {
        this.form = form;
        this.driver = driver;
        form.setVisible(true);

        //When deliver button pressed, change status of order to Delivered
        form.getDeliverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderIdText = form.getIdTextField().getText();
                try {
                    int orderId = Integer.parseInt(orderIdText);
                    DatabaseUtil.updateOrderStatus(orderId, "Delivered");
                    DatabaseUtil.updateDeliveredBy(orderId, form.getDriver().getfName()
                            + " " + form.getDriver().getlName());
                    JOptionPane.showMessageDialog(form.getMainPanel(), "Order Delivered.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(form.getMainPanel(), "Please enter a valid order ID.");
                }
            }
        });

        form.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                DriverMainFormController newForm = new DriverMainFormController(new DriverMainForm(driver),driver);
            }
        });
    }
}
