package org.example.view.driverview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Order;
import org.example.model.UserDriver;

import javax.swing.*;
import java.util.List;

public class DriverDeliverForm extends JFrame {
    private JPanel mainPanel;
    private JList orderList;
    private JButton deliverButton;
    private JTextField idTextField;
    private JButton backButton;
    public UserDriver driver;

    public DriverDeliverForm(UserDriver userDriver) {
        this.driver = userDriver;
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        List<Order> orders = DatabaseUtil.queryProcessedOrders();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            listModel.addElement("Order ID: " + order.getOrderId() + ", Total: $" + order.getPrice() +
                    ", Status: " + order.getProcessStatus());
        }
        orderList.setModel(listModel);
    }

    public UserDriver getDriver() {
        return driver;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JList getOrderList() {
        return orderList;
    }

    public JButton getDeliverButton() {
        return deliverButton;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
