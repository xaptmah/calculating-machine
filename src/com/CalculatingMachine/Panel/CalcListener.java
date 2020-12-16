package com.CalculatingMachine.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private final JTextField inputField;
    private final JTextField operationsHistoryField;
    //private final CalcMemory calcMemory = new CalcMemory();

    public CalcListener(JTextField inputField, JTextField operationsHistoryField) {
        this.inputField = inputField;
        this.operationsHistoryField = operationsHistoryField;
    }


    public void actionPerformed(ActionEvent e) {
        CalcButton button = ((CalcButton) e.getSource());
        switch (button.TYPE) {
            case INPUT:
                enterNumbers(button);
                break;
            case OPERATION:
                saveOperandAndDefineOperator(button);
                break;
            case EQUAL:
                outputCalculate(button);
                break;
            case CLEAR:
                clear();
                break;
            case NEGATIVE:
                installOrUninstall();
                break;

        }

    }

    private void enterNumbers(CalcButton button) {
        if (isThereInside(inputField, "Enter digits")) {
            clearField(inputField);
            setSymbol(inputField, button.getText());
        } else if (hasDot(button)) {
            deleteDot();
        } else if (!isContains(operationsHistoryField, "=")) {
            setSymbol(inputField, button.getText());
        }
    }

    private void saveOperandAndDefineOperator(CalcButton button) {
        if (!isThereInside(inputField, "") && !isThereOperands(inputField) && isThereInside(operationsHistoryField, "")) {
            saveOperand();
            saveOperator(button);
            moveStringTo(operationsHistoryField, button);
            clearField(inputField);
        }
    }

    private void outputCalculate(CalcButton button) {
        if (!isThereInside(operationsHistoryField, "") && !isThereInside(inputField, "") && !isContains(operationsHistoryField, "=")) {
            saveOperand();
            moveStringTo(operationsHistoryField, button);
            outputTheResult(calculate());

        }
    }

    private void clear() {
        CalcMemory.clear();
        clearField(operationsHistoryField);
        clearField(inputField);
    }

    private void installOrUninstall() {
        if (isThereInside(inputField, "Enter digits")) {
            clearField(inputField);
        }
        if (!isThereInside(inputField, "") && !isContains(operationsHistoryField, "=")) {
            if (isElementPosition(inputField, '-', 0)) {
                deleteFirstElement(inputField);
            } else {
                setSignNegative(inputField);
            }
        }
    }



    private String calculate() {

        switch (getOperator()) {
            case "+":

                return String.valueOf(CalcMemory.getOperand(0) + CalcMemory.getOperand(1));

            case "-":
                return String.valueOf(CalcMemory.getOperand(0) - CalcMemory.getOperand(1));

            case "*":
                return String.valueOf(CalcMemory.getOperand(0) * CalcMemory.getOperand(1));

            case "/":
                return String.valueOf(CalcMemory.getOperand(0) / CalcMemory.getOperand(1));

        }
        return "";
    }

    private String getOperator() {
        return CalcMemory.getOperator(0);
    }

    private void outputTheResult(String result) {
        inputField.setText(result);
        operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText());
    }



    private boolean isElementPosition(JTextField field, char element, int position) {
        return element == field.getText().charAt(position);
    }




    private void saveOperator(CalcButton button) {CalcMemory.setOperator(button.getText());}


    private void saveOperand() {CalcMemory.setOperand(inputField.getText());}



    private void deleteDot() {
        if (dotEndElement()) {
            inputField.setText(inputField.getText().substring(0, lastPosition(inputField)));
        }
    }

    private boolean dotEndElement() {
        return isElementPosition(inputField, '.', lastPosition(inputField));
    }

    private boolean hasDot(CalcButton button) {return inputField.getText().contains(".") && button.getText().contains(".");}

    private void setSymbol(JTextField field, String button) {field.setText(field.getText() + button);}
    private boolean isThereInside(JTextField field, String element) {
        return element.equals(field.getText());
    }
    private void moveStringTo(JTextField operationsHistoryField, CalcButton button) {
        operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText() + button.getText());
    }
    private boolean isContains(JTextField operationsHistoryField, String element) {
        return operationsHistoryField.getText().contains(element);
    }





    private int lastPosition(JTextField field) {
        return field.getText().length() - 1;
    }

    private boolean isThereOperands(JTextField field) {
        return "Enter digits".equals(field.getText());
    }

    private void clearField(JTextField inputField) {
        inputField.setText("");
    }

    private void setSignNegative(JTextField inputField) {inputField.setText("-" + inputField.getText());}

    private void deleteFirstElement(JTextField inputField) {inputField.setText(inputField.getText().substring(1));}







}

