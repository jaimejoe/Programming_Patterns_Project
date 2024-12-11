package org.example.controller.drivercontroller;

import org.example.model.UserDriver;
import org.example.view.driverview.DriverMainForm;

public class DriverMainFormController {
    public DriverMainForm driverMainForm;
    public UserDriver userDriver;

    public DriverMainFormController(DriverMainForm driverMainForm, UserDriver userDriver) {
        this.driverMainForm = driverMainForm;
        this.userDriver = userDriver;
        driverMainForm.setVisible(true);
    }
}
