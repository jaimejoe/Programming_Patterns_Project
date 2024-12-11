package org.example.view.customerview;

import org.example.model.Customer;
import org.example.model.Order;

import javax.swing.*;

public class CustomerOrderForm extends JFrame {
    private JPanel mainPanel;
    private JButton pizzaButton;
    private JButton burgerButton;
    private JButton saladButton;
    private JButton hotDogButton;
    private JButton submitButton;
    private JButton backButton;
    private Order order;

    public CustomerOrderForm(Customer customer) {
        order = new Order();
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        order.setCustomer(customer);

    }

    public JButton getBackButton() {
        return backButton;
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