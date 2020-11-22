package com.CalculatingMachine.Panel;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagConstraints;

public class GetButton extends Container {
    private final JTextField output;
    private final JTextField output2;

    public GetButton(Container jPanel,JTextField output, JTextField output2) {
        this.output = output;
        this.output2 = output2;
        getButton(jPanel);
    }

    private void getButton(Container jPanel) {
        int numberButton = 10;
        for (int i = 3; i < 6; i++) {
            for (int y = 4; y > 1; y--) {
                addButton(jPanel, String.valueOf(--numberButton), y, i, CalcButton.Type.INPUT);
            }
        }
        addButton(jPanel, "=", 5, 3, CalcButton.Type.EQUAL);
        addButton(jPanel, "0", 2, 6, CalcButton.Type.INPUT);
        addButton(jPanel, "-", 5, 5, CalcButton.Type.OPERATION);
        addButton(jPanel, "+", 5, 6, CalcButton.Type.OPERATION);
        addButton(jPanel, ".", 4, 6, CalcButton.Type.INPUT);
        addButton(jPanel, "C", 2, 2, CalcButton.Type.CLEAR);
        addButton(jPanel, "/", 3, 2, CalcButton.Type.OPERATION);
        addButton(jPanel, "*", 4, 2, CalcButton.Type.OPERATION);
        addButton(jPanel, "±", 5, 2, CalcButton.Type.NEGATIVE);
    }

    private void addButton(Container jPanel, String text, int x, int y, CalcButton.Type type) {
        JButton subtract = new CalcButton(text, type);
        jPanel.add(subtract, getLocationButton(x, y, text));
        subtract.addActionListener(new CalcListener(output, output2));
    }


    private GridBagConstraints getLocationButton(int gx, int gy, String text) {
        GridBagConstraints result = new GridBagConstraints();
        getLocationButton(result, gx, gy, text);
        return result;
    }

    private void buttonSize(GridBagConstraints result, String text) {
        if (text.equals("=")) {
            result.gridheight = 2;
        } else if (text.equals("0")) {
            result.gridwidth = 2;
        } else {
            result.gridwidth = 1;
        }

    }

    private void getLocationButton(GridBagConstraints result, int gx, int gy, String text) {
        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        buttonSize(result, text);
        result.fill = GridBagConstraints.BOTH;
    }
}
