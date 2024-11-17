package org.example.view.customerview;

import javax.swing.*;
import java.awt.*;

public class customerViewForm extends JFrame {
    private JPanel mainPanel;
    private JLabel customerOptionsLabel;
    private JButton ordeBtn;
    private JButton cancelButton;
    private JButton viewOrdersButton;

    public customerViewForm() throws HeadlessException {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
