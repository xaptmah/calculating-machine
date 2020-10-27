package com.CalculatingMachine.Panel;


import javax.swing.JPanel;
import javax.swing.JTextField;

public class OutPanel extends JPanel {
    public OutPanel() {
        setLayout(null);
        JTextField output = new JTextField();
        output.setBounds(10,10,200,50);
        output.setEditable(false);
        add(output);
    }
}
