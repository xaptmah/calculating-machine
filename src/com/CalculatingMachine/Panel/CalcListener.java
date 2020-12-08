package com.CalculatingMachine.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CalcListener implements ActionListener {

    private final JTextField inputField;
    private final JTextField operationsHistoryField;
    private final List<String> operands;
    private final List<String> operators;

    public CalcListener(JTextField inputField, JTextField operationsHistoryField, List<String> operands,List<String> operators) {
        this.inputField = inputField;
        this.operationsHistoryField = operationsHistoryField;
        this.operands = operands;
        this.operators = operators;
    }



    public void actionPerformed(ActionEvent e) {
        CalcButton button = ((CalcButton) e.getSource());
        switch (button.TYPE) {
            case INPUT:

                if ("Enter digits".equals(inputField.getText())){
                    inputField.setText("");
                    inputField.setText(inputField.getText() + button.getText());


                }else if (inputField.getText().contains(".") && button.getText().contains(".") ){

                }else {
                    inputField.setText(inputField.getText() + button.getText());

                }
                break;
            case OPERATION:
                if (operationsHistoryField.getText().equals("")){
                    //operands.add(inputField.getText());
                    //System.out.println("позиция1 "+operands.get(0));
                    //System.out.println("заполнение списка "+operands.size());
                    operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText() + button.getText());
                    inputField.setText("");
                }else if((operationsHistoryField.getText()).contains("=")){
                    operationsHistoryField.setText("");
                    operationsHistoryField.setText(inputField.getText() + button.getText());
                    inputField.setText("");
                }else {
                    operationsHistoryField.setText(operationsHistoryField.getText());
                    //output.setText(String.valueOf((output2.getText()).compareTo("*")));
                }



                break;
            case EQUAL:
                //output2.setText(output2.getText() + output.getText());
                if(!(operationsHistoryField.getText()).contains("=")){

                }else {
                    operationsHistoryField.setText(operationsHistoryField.getText());
                }


                //
                break;
            case CLEAR:
                operands.clear();
                operationsHistoryField.setText("");
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

    }//output.setText(task);/**/









}

