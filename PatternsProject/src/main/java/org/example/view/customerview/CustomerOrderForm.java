package org.example.view.customerview;

import org.example.model.FoodItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOrderForm {
    private JPanel mainPanel;
    private JButton pizzaButton;
    private JButton burgerButton;
    private JButton saladButton;
    private JButton hotDogButton;
    private JButton submitButton;
    public FoodItem pizza;
    public FoodItem salad;
    public FoodItem hotDog;
    public FoodItem burger;


    public CustomerOrderForm() {
        pizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
