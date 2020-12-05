package com.CalculatingMachine.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private final JTextField inputField;
    private final JTextField operationsHistoryFeald;

    public CalcListener(JTextField inputField, JTextField operationsHistoryFeald) {
        this.inputField = inputField;
        this.operationsHistoryFeald = operationsHistoryFeald;

    }

    public void actionPerformed(ActionEvent e) {
        CalcButton button = ((CalcButton) e.getSource());
        //
        switch (button.TYPE) {
            case INPUT:
                String dot = button.getText();
                if ("Enter digits".equals(inputField.getText())){
                    inputField.setText("");
                }else if ((inputField.getText()).contains(".")&&(button.getText()).contains(".") ){
                    inputField.setText(inputField.getText());
                }else {
                    inputField.setText(inputField.getText() + button.getText());
                }
                break;
            case OPERATION:
                if (operationsHistoryFeald.getText().equals("")){
                    operationsHistoryFeald.setText(operationsHistoryFeald.getText() + inputField.getText() + button.getText());
                    inputField.setText("");

                }else if((operationsHistoryFeald.getText()).contains("=")){
                    operationsHistoryFeald.setText("");
                    operationsHistoryFeald.setText(inputField.getText() + button.getText());
                    inputField.setText("");
                }else {
                    operationsHistoryFeald.setText(operationsHistoryFeald.getText());
                    //output.setText(String.valueOf((output2.getText()).compareTo("*")));
                }



                break;
            case EQUAL:
                //output2.setText(output2.getText() + output.getText());
                if(!(operationsHistoryFeald.getText()).contains("=")){
                    operationsHistoryFeald.setText(operationsHistoryFeald.getText()+ inputField.getText());
                    inputField.setText(computation(operationsHistoryFeald.getText()));

                    operationsHistoryFeald.setText(operationsHistoryFeald.getText()+ "=" + computation(operationsHistoryFeald.getText()));


                }else {
                    operationsHistoryFeald.setText(operationsHistoryFeald.getText());
                }


                //
                break;
            case CLEAR:
                operationsHistoryFeald.setText("");
                inputField.setText("");
                break;
            case NEGATIVE:
                if ("Enter digits".equals(inputField.getText())){
                    inputField.setText("");
                }
                if (!"".equals(inputField.getText())){
                    if ('-' == inputField.getText().charAt(0)) {
                        inputField.setText(inputField.getText().substring(1));
                    } else {
                        inputField.setText("-" + inputField.getText());
                    }
                }
                break;

        }

    }//output.setText(task);
    private String computation(String task){
        if('-' == task.charAt(0)){
            if(task.substring(1).contains("-")){
                return String.valueOf(Double.parseDouble(("-"+task.substring(1,task.substring(1).indexOf('-')+1))) - Double.parseDouble(task.substring(task.substring(1).indexOf('-')+2)));
            }
        }else if(task.contains("-")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('-'))) - Double.parseDouble(task.substring(task.indexOf('-') + 1)));
        }else if (task.contains("+")) {
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('+'))) + Double.parseDouble(task.substring(task.indexOf('+') + 1)));
        }else if (task.contains("/")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('/'))) / Double.parseDouble(task.substring(task.indexOf('/') + 1)));
        }else if (task.contains("*")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('*'))) * Double.parseDouble(task.substring(task.indexOf('*') + 1)));
        }
        return task;
    }

}

