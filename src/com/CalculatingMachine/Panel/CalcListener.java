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
                if (areThereOperands(inputField)){
                    clearField(inputField);
                    setSymbol(inputField,button.getText());
                }else if (hasDot(button)){
                    deleteDot();
                }else {
                    setSymbol(inputField,button.getText());
                }
                break;
            case OPERATION:
                if(!checkFilling(inputField) && !areThereOperands(inputField) && checkFilling(operationsHistoryField)){
                    saveOperand();
                    saveOperator(button);
                    moveStringTo(operationsHistoryField,button);
                    clearField(inputField);
                }
                break;
            case EQUAL:
                if(!(operationsHistoryField.getText()).contains("=")){
                    saveOperand();
                    moveStringTo(operationsHistoryField,button);
                }


                //
                break;
            case CLEAR:
                operands.clear();
                clearField(operationsHistoryField);
                clearField(inputField);

                break;
            case NEGATIVE:
                if (areThereOperands(inputField)){
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

    }

    private void moveStringTo(JTextField operationsHistoryField,CalcButton button) {
        operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText() + button.getText());
    }


    private void saveOperator(CalcButton button) {
        operators.add(button.getText());
    }


    private void saveOperand() {
        operands.add(inputField.getText());
    }

    private boolean checkFilling(JTextField field) {

        return "".equals(field.getText());
    }

    private void deleteDot() {
        if(dotEndElement()){
            inputField.setText(inputField.getText().substring(0,inputField.getText().length()-1));
        }
    }

    private boolean dotEndElement() {
        return '.' == (inputField.getText().charAt(inputField.getText().length() - 1));
    }

    private boolean hasDot(CalcButton button) {

        return inputField.getText().contains(".") && button.getText().contains(".");
    }

    private boolean areThereOperands(JTextField field) {
        return "Enter digits".equals(field.getText());
    }

    private void clearField(JTextField inputField) {
        inputField.setText("");
    }

    private void setSymbol(JTextField field, String button) {

        field.setText(field.getText() + button);
    }


}

