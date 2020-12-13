package com.CalculatingMachine.Panel;

import com.CalculatingMachine.Panel.CalcButton.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;


public class WindowCM {


    private final JTextField inputField = new JTextField("Enter digits");
    private final JTextField operationsHistoryField = new JTextField();
    private List<String> operands;
    private List<String> operators;

    public void addComponentsToWindow(Container jPanel) {
        this.operands = new ArrayList<>();
        this.operators = new ArrayList<>();


        jPanel.setBounds(0, 0, 240, 340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        jPanel.revalidate();
        operationsHistoryField.setEditable(false);
        inputField.setEditable(false);
        jPanel.add(inputField, new GridBag(0, 1, inputField.getText()));
        jPanel.add(operationsHistoryField, new GridBag(0, 0, inputField.getText()));
        getButtonListener(jPanel);


    }

    private void getButtonListener(Container jPanel) {
        int numberButton = 10;
        for (int i = 3; i < 6; i++) {
            for (int z = 4; z > 1; z--) {
                addButton(jPanel, String.valueOf(--numberButton), z, i, Type.INPUT);
            }
        }

        addButton(jPanel, "C", 2, 2, Type.CLEAR);
        addButton(jPanel, "0", 2, 6, Type.INPUT);
        addButton(jPanel, "/", 3, 2, Type.OPERATION);
        addButton(jPanel, "*", 4, 2, Type.OPERATION);
        addButton(jPanel, ".", 4, 6, Type.INPUT);
        addButton(jPanel, "±", 5, 2, Type.NEGATIVE);
        addButton(jPanel, "=", 5, 3, Type.EQUAL);
        addButton(jPanel, "-", 5, 5, Type.OPERATION);
        addButton(jPanel, "+", 5, 6, Type.OPERATION);

    }


    private void addButton(Container jPanel, String text, int x, int y, Type type) {
        JButton subtract = new CalcButton(text, type);
        jPanel.add(subtract, new GridBag(x, y, text));
        subtract.addActionListener(new CalcListener(inputField, operationsHistoryField));
    }


    public void show() {
        JFrame window = new JFrame("Calculating Machine");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        addComponentsToWindow(window.getContentPane());
        window.setVisible(true);
        window.pack();
        //window.setResizable(false);
    }
}
