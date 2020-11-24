package com.CalculatingMachine.Panel;

import com.CalculatingMachine.CalculatingMachine;

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
                if ("Enter digits".equals(output.getText())){
                    output.setText("");
                }
                output.setText((output.getText() + button.getText()));
                break;
            case OPERATION:
                output2.setText(output2.getText() + output.getText() + button.getText());
                output.setText("");
                break;
            case EQUAL:
                //output2.setText(output2.getText() + output.getText());

                output2.setText(computation((output2.getText()+output.getText())));
                output.setText(computation((output2.getText()+output.getText())));
                //
                break;
            case CLEAR:
                output2.setText("");
                output.setText("");
                break;
            case NEGATIVE:
                if ("Enter digits".equals(output.getText())){
                    output.setText("");
                }
                if (!"".equals(output.getText())){
                    if ('-' == output.getText().charAt(0)) {
                        output.setText(output.getText().substring(1));
                    } else {
                        output.setText("-" + output.getText());
                    }
                }
                break;

        }

    }//output.setText(task);
    private String computation(String task){
        if('-' == task.charAt(0)){
            if(task.substring(1).contains("-")){
                return String.valueOf(Double.parseDouble(("-"+task.substring(1,task.substring(1).indexOf('-')+1))) - Integer.parseInt(task.substring(task.substring(1).indexOf('-')+2)));
            }
        }else if(task.contains("-")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('-'))) - Integer.parseInt(task.substring(task.indexOf('-') + 1)));
        }else if (task.contains("+")) {
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('+'))) + Integer.parseInt(task.substring(task.indexOf('+') + 1)));
        }else if (task.contains("/")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('/'))) / Integer.parseInt(task.substring(task.indexOf('/') + 1)));
        }else if (task.contains("*")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('*'))) * Integer.parseInt(task.substring(task.indexOf('*') + 1)));
        }
        return task;
    }

}

