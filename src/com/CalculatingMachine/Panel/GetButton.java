package com.CalculatingMachine.Panel;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagConstraints;
import static com.CalculatingMachine.Panel.CalcButton.Type;

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
                addButton(jPanel, String.valueOf(--numberButton), y, i, Type.INPUT);
            }
        }
        addButton(jPanel, "=", 5, 3, Type.EQUAL);
        addButton(jPanel, "0", 2, 6, Type.INPUT);
        addButton(jPanel, "-", 5, 5, Type.OPERATION);
        addButton(jPanel, "+", 5, 6, Type.OPERATION);
        addButton(jPanel, ".", 4, 6, Type.INPUT);
        addButton(jPanel, "C", 2, 2, Type.CLEAR);
        addButton(jPanel, "/", 3, 2, Type.OPERATION);
        addButton(jPanel, "*", 4, 2, Type.OPERATION);
        addButton(jPanel, "±", 5, 2, Type.NEGATIVE);
    }

    private void addButton(Container jPanel, String text, int x, int y, Type type) {
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
