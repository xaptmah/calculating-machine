package com.CalculatingMachine.Panel;



import javax.swing.JPanel;
import javax.swing.JTextField;

public class OutPanel extends JPanel {
    public OutPanel() {
        JTextField output = new JTextField(20);
        output.setEditable(false);
        add(output);
    }

}
