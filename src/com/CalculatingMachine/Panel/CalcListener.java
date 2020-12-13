package com.CalculatingMachine.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private final JTextField inputField;
    private final JTextField operationsHistoryField;
    private CalcMemory calcMemory = new CalcMemory();

    public CalcListener(JTextField inputField, JTextField operationsHistoryField) {
        this.inputField = inputField;
        this.operationsHistoryField = operationsHistoryField;
    }


    public void actionPerformed(ActionEvent e) {
        CalcButton button = ((CalcButton) e.getSource());
        switch (button.TYPE) {
            case INPUT:
                if (isThereInside(inputField, "Enter digits")) {
                    clearField(inputField);
                    setSymbol(inputField, button.getText());
                } else if (hasDot(button)) {
                    deleteDot();
                } else if( !isContains(operationsHistoryField,"=")){
                    setSymbol(inputField, button.getText());
                }
                break;
            case OPERATION:
                if (!isThereInside(inputField, "") && !isThereOperands(inputField) && isThereInside(operationsHistoryField, "")) {
                    saveOperand();
                    saveOperator(button);
                    moveStringTo(operationsHistoryField, button);
                    clearField(inputField);
                }
                break;
            case EQUAL:
                if (!isThereInside(operationsHistoryField, "") && !isThereInside(inputField,"") && !isContains(operationsHistoryField,"=")) {
                    saveOperand();
                    moveStringTo(operationsHistoryField, button);
                    outputTheResult(calculate());

                }
                break;
            case CLEAR:
                calcMemory.clear();
                clearField(operationsHistoryField);
                clearField(inputField);
                break;
            case NEGATIVE:
                if (isThereInside(inputField, "Enter digits")) {
                    clearField(inputField);
                }
                if (!isThereInside(inputField, "") && !isContains(operationsHistoryField,"=")) {
                    if (isElementPosition(inputField, '-', 0)) {
                        deleteFirstElement(inputField);
                    } else {
                        setSignNegative(inputField);
                    }
                }
                break;

        }

    }

    private boolean isContains(JTextField operationsHistoryField,String element) {
        return operationsHistoryField.getText().contains(element);
    }

    private String calculate() {

        switch (getOperator()){
            case "+":

                return String.valueOf(calcMemory.getOperand(0)+ calcMemory.getOperand(1)) ;

            case "-":
                return String.valueOf(calcMemory.getOperand(0)- calcMemory.getOperand(1)) ;

            case "*":
                return String.valueOf(calcMemory.getOperand(0)* calcMemory.getOperand(1)) ;

            case "/":
                return String.valueOf(calcMemory.getOperand(0)/ calcMemory.getOperand(1)) ;

        }
        return "";
    }

    private String getOperator() {
        return calcMemory.getOperator(0);
    }

    private void outputTheResult(String result) {
        inputField.setText(result);
        operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText());
    }

    private void setSignNegative(JTextField inputField) {
        inputField.setText("-" + inputField.getText());
    }

    private void deleteFirstElement(JTextField inputField) {
        inputField.setText(inputField.getText().substring(1));
    }

    private boolean isElementPosition(JTextField field, char element, int position) {
        return element == field.getText().charAt(position);
    }

    private void moveStringTo(JTextField operationsHistoryField, CalcButton button) {
        operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText() + button.getText());
    }


    private void saveOperator(CalcButton button) {
        calcMemory.setOperator(button.getText());
    }


    private void saveOperand() {
        calcMemory.setOperand(inputField.getText());
    }

    private boolean isThereInside(JTextField field, String element) {
        return element.equals(field.getText());
    }

    private void deleteDot() {
        if (dotEndElement()) {
            inputField.setText(inputField.getText().substring(0, lastPosition(inputField)));
        }
    }

    private boolean dotEndElement() {
        return isElementPosition(inputField, '.', lastPosition(inputField));
    }

    private int lastPosition(JTextField field) {
        return field.getText().length() - 1;
    }

    private boolean hasDot(CalcButton button) {

        return inputField.getText().contains(".") && button.getText().contains(".");
    }

    private boolean isThereOperands(JTextField field) {
        return "Enter digits".equals(field.getText());
    }

    private void clearField(JTextField inputField) {
        inputField.setText("");
    }

    private void setSymbol(JTextField field, String button) {

        field.setText(field.getText() + button);
    }


}

