package com.CalculatingMachine.Panel;

import com.CalculatingMachine.Panel.CalcButton.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class WindiowCM {


    private final JTextField output = new JTextField("Enter digits");
    private final JTextField output2 = new JTextField();


    public void addComponentsToWindiow(Container jPanel) {


        jPanel.setBounds(0, 0, 240, 340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        jPanel.revalidate();
        output2.setEditable(false);
        jPanel.add(output, getLocationElement(0, 1, output.getText()));
        jPanel.add(output2, getLocationElement(0, 0, output.getText()));
        getButtonListener(jPanel);

    }

    private void getButtonListener(Container jPanel) {
        int numberButton = 10;
        for (int i = 3; i < 6; i++) {
            for (int y = 4; y > 1; y--) {
                addButton(jPanel, String.valueOf(--numberButton), y, i, Type.INPUT);
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
        jPanel.add(subtract, getLocationElement(x, y, text));
        subtract.addActionListener(new CalcListener(output, output2));
    }

    private GridBagConstraints getLocationElement(int gx, int gy, String text) {
        GridBagConstraints result = new GridBagConstraints();
        getLocationElement(result, gx, gy, text);
        return result;
    }

    private void getLocationElement(GridBagConstraints result, int gx, int gy, String text) {
        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        buttonSize(result, text);
        result.fill = GridBagConstraints.BOTH;
    }

    private void buttonSize(GridBagConstraints result, String text) {
        if (text.equals("=")) {
            result.gridheight = 2;
        } else if (text.equals("0")) {
            result.gridwidth = 2;
        } else if (text.equals("Enter digits")) {
            result.gridwidth = 7;
        } else {
            result.gridwidth = 1;
        }

    }

    public void show() {
        JFrame window = new JFrame("Calculating Machine");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        addComponentsToWindiow(window.getContentPane());
        window.setVisible(true);
        window.pack();
        //window.setResizable(false);
    }
}
