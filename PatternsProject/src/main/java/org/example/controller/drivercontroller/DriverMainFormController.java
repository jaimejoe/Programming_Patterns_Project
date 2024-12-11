package org.example.controller.drivercontroller;

import org.example.controller.MainFrameController;
import org.example.model.UserDriver;
import org.example.view.MainFrameForm;
import org.example.view.driverview.DriverDeliverForm;
import org.example.view.driverview.DriverMainForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMainFormController {
    public DriverMainForm form;
    public UserDriver userDriver;

    public DriverMainFormController(DriverMainForm form, UserDriver userDriver) {
        this.form = form;
        this.userDriver = userDriver;
        form.setVisible(true);

//        When deliver button pressed, send to DriverDeliverForm
        form.getDeliverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                DriverDeliverForm deliverForm = new DriverDeliverForm(userDriver);
                DriverDeliverController driverDeliverController = new DriverDeliverController(deliverForm, userDriver);
            }
        });
        form.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
                MainFrameController newForm = new MainFrameController(new MainFrameForm());
            }
        });
    }
}
