package org.example.view.customerview;

import org.example.controller.util.DatabaseUtil;
import org.example.model.Customer;
import org.example.model.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerCancelForm extends JFrame {
    private JList orderList;
    private JTextField idTextField;
    private JButton cancelButton;
    private JLabel idLabel;
    private JPanel mainPanel;

    public CustomerCancelForm(Customer customer) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        List<Order> orders = DatabaseUtil.queryOrdersByCustomerId(customer.getCustomerId());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Order order : orders) {
            order.setCustomer(customer);
            if (order.getCustomer().getCustomerId() == customer.getCustomerId()) {
                listModel.addElement("Order ID: " + order.getOrderId() + ", Total: $" + order.getPrice());
            }
        }
        orderList.setModel(listModel);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderIdText = idTextField.getText();
                try {
                    int orderId = Integer.parseInt(orderIdText);
                    DatabaseUtil.deleteOrder(orderId);
                    JOptionPane.showMessageDialog(mainPanel, "Order cancelled.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a valid order ID.");
                }
            }
        });
    }
}
