package org.example.view.driverview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Order;
import org.example.model.UserDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DriverDeliverForm extends JFrame {
    private JPanel mainPanel;
    private JList orderList;
    private JButton deliverButton;
    private JTextField idTextField;

    public DriverDeliverForm(UserDriver userDriver) {
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
        deliverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderIdText = idTextField.getText();
                try {
                    int orderId = Integer.parseInt(orderIdText);
                    DatabaseUtil.updateOrderStatus(orderId, "Delivered");
                    DatabaseUtil.updateDeliveredBy(orderId, userDriver.getfName()
                            + " " + userDriver.getlName());
                    JOptionPane.showMessageDialog(mainPanel, "Order Delivered.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a valid order ID.");
                }
            }
        });
    }
}
