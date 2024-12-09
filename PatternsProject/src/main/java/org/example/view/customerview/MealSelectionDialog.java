package org.example.view.customerview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MealSelectionDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton singleItemRadioButton;
    private JRadioButton mealRadioButton;
    private boolean mealSelected; // Track if meal is selected

    public MealSelectionDialog() {
        setTitle("Select Meal Type");
        setModal(true); // Make the dialog modal
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the dialog

        // Initialize components
        contentPane = new JPanel();
        buttonOK = new JButton("OK");
        buttonCancel = new JButton("Cancel");
        singleItemRadioButton = new JRadioButton("Single Item");
        mealRadioButton = new JRadioButton("Meal");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(singleItemRadioButton);
        group.add(mealRadioButton);

        // Set layout for the content pane
        contentPane.setLayout(new GridLayout(4, 1)); // 4 rows, 1 column
        contentPane.add(singleItemRadioButton);
        contentPane.add(mealRadioButton);
        contentPane.add(buttonOK);
        contentPane.add(buttonCancel);

        setContentPane(contentPane); // Set the content pane

        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mealRadioButton.isSelected()) {
                    mealSelected = true;
                } else if (singleItemRadioButton.isSelected()) {
                    mealSelected = false;
                } else {
                    JOptionPane.showMessageDialog(MealSelectionDialog.this,
                            "Please select a meal type.",
                            "Selection Required",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // Call onCancel() when the cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // Call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        mealSelected = false;
        dispose();
    }

    public boolean isMealSelected() {
        return mealSelected;
    }

    public static void main(String[] args) {
        MealSelectionDialog dialog = new MealSelectionDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}