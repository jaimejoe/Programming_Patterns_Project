package org.example.controller;

import org.example.model.*;
import org.example.view.MainFrameForm;

public class UserController {
    Customer customer;
    Admin admin;
    UserDriver userDriver;
    MainFrameForm mainFrameForm;

    public UserController(MainFrameForm mainFrameForm) {
        this.mainFrameForm = mainFrameForm;
    }
}
