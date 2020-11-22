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
        jPanel.add(new GetButton(jPanel,output,output2));
    }

    private GridBagConstraints getLocationTextField(int gr, int ipy, int gy) {
        GridBagConstraints result = new GridBagConstraints();
        result.gridy = gy;
        result.gridwidth = gr;
        result.ipady = ipy;
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
