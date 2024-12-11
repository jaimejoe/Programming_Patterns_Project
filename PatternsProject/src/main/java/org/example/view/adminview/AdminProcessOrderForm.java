package org.example.view.adminview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminProcessOrderForm extends JFrame {

    private JPanel mainPanel;
    private JList orderList;
    private JTextField idTextField;
    private JButton processButton;
    private JLabel idLabel;

    public AdminProcessOrderForm() {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        List<Order> orders = DatabaseUtil.queryAllOrders();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            listModel.addElement("Order ID: " + order.getOrderId() + ", Customer ID: " + order.getCustomerId() +
                    ", Total: $" + order.getPrice() + ", Status: " + order.getProcessStatus());
        }
        orderList.setModel(listModel);

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderIdText = idTextField.getText();
                try {
                    int orderId = Integer.parseInt(orderIdText);
                    DatabaseUtil.updateOrderStatus(orderId, "Processed");
                    JOptionPane.showMessageDialog(mainPanel, "Order Processed.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a valid order ID.");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JList getOrderList() {
        return orderList;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JButton getProcessButton() {
        return processButton;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }
}