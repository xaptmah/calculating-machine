package com.CalculatingMachine.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons extends JPanel {

    public Buttons(){
        setLayout(null);

        JButton b1 = new JButton("123");
        b1.setBounds(100,100,55,50);
        add(b1);
    }
}
