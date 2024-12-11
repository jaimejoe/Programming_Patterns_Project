package org.example.controller.customercontroller;

import org.example.controller.FoodItemFactory;
import org.example.controller.util.DatabaseUtil;
import org.example.model.Customer;
import org.example.model.FoodItem;
import org.example.model.Order;
import org.example.view.customerview.CustomerMainForm;
import org.example.view.customerview.CustomerOrderForm;
import org.example.view.customerview.MealSelectionDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerOrderFormController {
    public CustomerOrderForm customerOrderForm;
    public Customer customer;
    public Order order;
    public JPanel mainPanel;

    public CustomerOrderFormController(CustomerOrderForm customerOrderForm, Customer customer) {
        this.customerOrderForm = customerOrderForm;
        this.customer = customer;
        this.order = customerOrderForm.getOrder();
        this.mainPanel = customerOrderForm.getMainPanel();
        customerOrderForm.setVisible(true);

        //When Pizza button pressed, add pizza to order
        customerOrderForm.getPizzaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealSelection(FoodItemFactory.createPizza());
            }
        });

        //When burger button pressed, add burger to order
        customerOrderForm.getBurgerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealSelection(FoodItemFactory.createBurger());
            }
        });

        //When Salad button pressed, add Salad to order
        customerOrderForm.getSaladButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealSelection(FoodItemFactory.createSalad());
            }
        });

        //When Hotdog button pressed, add Hotdog to order
        customerOrderForm.getHotDogButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealSelection(FoodItemFactory.createHotDog());
            }
        });

        //When submit button pressed, change balance, change status to pending, insert into db, update db
        customerOrderForm.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customer.getBalance() > order.getPrice()) {
                    JOptionPane.showMessageDialog(mainPanel, "Proceeding to payment. Total: $" + order.getPrice());
                    customer.setBalance(customer.getBalance() - customerOrderForm.getOrder().getPrice());
                    customerOrderForm.getOrder().setProcessStatus("Pending");
                    DatabaseUtil.insertRecordsOrders(order);
                    DatabaseUtil.updateCustomerBalance(customer.getCustomerId(), customer.getBalance());
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Insufficient funds.");
                }
                order.setItems(new ArrayList<>());
                order.setPrice(0);
            }
        });
        customerOrderForm.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerOrderForm.dispose();
                CustomerMainFormController newForm = new CustomerMainFormController(new CustomerMainForm(customer),customer);
            }
        });
    }

    /**
     * When any button is pressed, choice between meal or single item, meal adds 1.5x more to price
     * @param item
     */
    private void mealSelection(FoodItem item) {
        MealSelectionDialog dialog = new MealSelectionDialog();
        dialog.setVisible(true);

        boolean isMealSelected = dialog.isMealSelected();

        if (isMealSelected) {
            double mealPrice = item.getPrice() * 1.5;
            item.setPrice(mealPrice);
            JOptionPane.showMessageDialog(mainPanel, "Meal selected: " + item.getName() + " - Price: $" + mealPrice);
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Single item selected: " + item.getName() + " - Price: $" + item.getPrice());
        }

        order.getItems().add(item);
        order.setPrice(order.getPrice() + item.getPrice());
        JOptionPane.showMessageDialog(mainPanel, item.getName() + " added to order. Total: $" + order.getPrice());
    }
}
