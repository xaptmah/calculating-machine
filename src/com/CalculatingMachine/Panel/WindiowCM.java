package com.CalculatingMachine.Panel;

import com.CalculatingMachine.Panel.CalcButton.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
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
        output.setEditable(false);
        jPanel.add(output, new GridBag(0, 1, output.getText()));
        jPanel.add(output2, new GridBag(0, 0, output.getText()));
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
        GridBag gridBag = new GridBag(x, y, text);
        jPanel.add(subtract, gridBag);
        subtract.addActionListener(new CalcListener(output, output2));
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
