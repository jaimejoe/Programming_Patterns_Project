package org.example.view.customerview;

import org.example.controller.FoodItemFactory;
import org.example.model.Customer;
import org.example.model.FoodItem;
import org.example.model.Order;
import org.example.controller.util.DatabaseUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerOrderForm extends JFrame {
    private JPanel mainPanel;
    private JButton pizzaButton;
    private JButton burgerButton;
    private JButton saladButton;
    private JButton hotDogButton;
    private JButton submitButton;
    private Order order;

    public CustomerOrderForm(Customer customer) {
        order = new Order();
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        order.setCustomer(customer);

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getPizzaButton() {
        return pizzaButton;
    }

    public JButton getBurgerButton() {
        return burgerButton;
    }

    public JButton getSaladButton() {
        return saladButton;
    }

    public JButton getHotDogButton() {
        return hotDogButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public Order getOrder() {
        return order;
    }
}