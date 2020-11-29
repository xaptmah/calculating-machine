package com.CalculatingMachine.Panel;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private final JTextField inputField;
    private final JTextField operationsHistoryFeald;


    public CalcListener(JTextField output, JTextField operationsHistory) {
        this.inputField = output;
        this.operationsHistoryFeald = operationsHistory;

    }

    public void actionPerformed(ActionEvent e) {
        CalcButton button = ((CalcButton) e.getSource());

        switch (button.TYPE) {
            case INPUT:
                if ("Enter digits".equals(inputField.getText())) {
                    inputField.setText("");
                    inputField.setText(inputField.getText() + button.getText());
                } else if ((inputField.getText()).contains(".") && (button.getText()).contains(".")) {
                    inputField.setText(inputField.getText());
                }else {
                    inputField.setText(inputField.getText() + button.getText());
                }
                break;
            case OPERATION:
                if (inputField.getText().equals("")) {
                    operationsHistoryFeald.setText(inputField.getText() + inputField.getText());
                    inputField.setText("");
                }

                break;
            case EQUAL:

                operationsHistoryFeald.setText(operationsHistoryFeald.getText() + inputField.getText());

                operationsHistoryFeald.setText(operationsHistoryFeald.getText() +"="+ calculate(operationsHistoryFeald.getText()));

                break;
            case CLEAR:
                operationsHistoryFeald.setText("");
                inputField.setText("");
                break;
            case NEGATIVE:
                if ("Enter digits".equals(inputField.getText())) {
                    inputField.setText("");
                }
                if (!"".equals(inputField.getText())) {
                    if ('-' == inputField.getText().charAt(0)) {
                        inputField.setText(inputField.getText().substring(1));
                    } else {
                        inputField.setText("-" + inputField.getText());
                    }
                }
                break;

        }

    }//output.setText(task);

    private String calculate(String task) {

            String operation = define(task);


        String primaryNumber ="";
        String secondaryNumber= "";



        Double primaryNumbe = Double.parseDouble(primaryNumber);
        //System.out.println("__"+primaryNumbe);
        Double secondaryNumbe = Double.parseDouble(secondaryNumber);
        //System.out.println("__"+secondaryNumbe);
        switch (operation){
            case "-":
                return String.valueOf(primaryNumbe - secondaryNumbe);
            case "+":
                return String.valueOf(primaryNumbe + secondaryNumbe);
            case "*":
                return String.valueOf(primaryNumbe * secondaryNumbe);
            case "/":
                return String.valueOf(primaryNumbe / secondaryNumbe);
        }

        return "2";
    }
    private String define(String expressionSign){
        if ("-".equals(expressionSign.charAt(0))){

        }

    }

}

