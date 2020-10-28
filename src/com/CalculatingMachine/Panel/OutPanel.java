package com.CalculatingMachine.Panel;



import javax.swing.JTextField;

public class OutPanel extends Buttons {
    public OutPanel() {
        setLayout(null);
        JTextField output = new JTextField();
        output.setBounds(10,10,205,50);
        output.setEditable(false);
        add(output);
    }
}
