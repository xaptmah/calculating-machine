package com.CalculatingMachine.Panel;

import com.CalculatingMachine.Panel.CalcButton.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class WindiowCM {


    private final JTextField output = new JTextField();
    private final JTextField output2 = new JTextField();


    public void addComponentsToWindiow(Container jPanel) {


        jPanel.setBounds(0, 0, 240, 340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        jPanel.revalidate();
        output2.setEditable(false);
        jPanel.add(output, getLocationTextField(7, 20, 1));
        jPanel.add(output2, getLocationTextField(7, 20, 0));
        getButtonListener(jPanel);


    }

    private void getButtonListener(Container jPanel) {
        int numberButton = 10;
        for (int i = 3; i < 6; i++) {
            for (int y = 4; y > 1; y--) {
                addButton(jPanel, String.valueOf(--numberButton), y, i, Type.INPUT);
            }
        }
        JButton calculate = new CalcButton("=", Type.EQUAL);
        jPanel.add(calculate, getLocationVerticalButton(5, 3, 2));
        calculate.addActionListener(new CalcListener(output, output2));

        JButton zero = new CalcButton("0", Type.INPUT);
        jPanel.add(zero, getLocationHorizontalButton(2, 6, 2));
        zero.addActionListener(new CalcListener(output, output2));

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
        jPanel.add(subtract, getLocationButtonDigit(x, y));
        subtract.addActionListener(new CalcListener(output, output2));
    }


    private GridBagConstraints getLocationTextField(int gr, int ipy, int gy) {
        GridBagConstraints result = new GridBagConstraints();
        result.gridy = gy;
        result.gridwidth = gr;
        result.ipady = ipy;
        result.fill = GridBagConstraints.HORIZONTAL;
        return result;
    }


    private GridBagConstraints getLocationButtonDigit(int gx, int gy) {
        GridBagConstraints result = new GridBagConstraints();

        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        result.gridwidth = 1;
        result.fill = GridBagConstraints.HORIZONTAL;
        //result.anchor = GridBagConstraints.LINE_START;
        return result;
    }

    private GridBagConstraints getLocationVerticalButton(int gx, int gy, int gr/*, int ipy*/) {
        GridBagConstraints result = new GridBagConstraints();
        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        result.gridheight = gr;
        //result.ipady = ipy;
        result.fill = GridBagConstraints.BOTH;

        return result;
    }

    private GridBagConstraints getLocationHorizontalButton(int gx, int gy, int gr/*, int ipy*/) {
        GridBagConstraints result = new GridBagConstraints();
        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        result.gridwidth = gr;
        //result.ipady = ipy;
        result.fill = GridBagConstraints.HORIZONTAL;
        return result;
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
