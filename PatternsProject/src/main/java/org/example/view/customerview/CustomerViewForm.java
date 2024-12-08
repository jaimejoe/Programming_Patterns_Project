package org.example.view.customerview;

import javax.swing.*;
import java.awt.*;

public class CustomerViewForm extends JFrame {
    private JPanel mainPanel;
    private JLabel customerOptionsLabel;
    private JButton ordeBtn;
    private JButton cancelButton;
    private JButton viewOrdersButton;

    public CustomerViewForm() throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
