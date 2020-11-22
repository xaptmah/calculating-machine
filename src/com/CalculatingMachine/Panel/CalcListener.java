package com.CalculatingMachine.Panel;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private final JTextField output;
    private final JTextField output2;

    public CalcListener(JTextField output, JTextField output2) {
        this.output = output;
        this.output2 = output2;
    }

    public void actionPerformed(ActionEvent e) {
        CalcButton button = ((CalcButton) e.getSource());
        //
        switch (button.TYPE) {
            case INPUT:
                output.setText((output.getText() + button.getText()));
                break;
            case OPERATION:
                output2.setText(output2.getText() + output.getText() + button.getText());
                output.setText("");
                break;
            case EQUAL:
                output.setText("FUCK");
                break;
            case CLEAR:
                output2.setText("");
                output.setText("");
                break;
            case NEGATIVE:
                if("".equals(output.getText())){
                    break;
                }else if ('-' == output.getText().charAt(0)) {
                    output.setText(output.getText().substring(1));
                } else {
                    output.setText("-" + output.getText());
                }
                break;
        }

    }
}

