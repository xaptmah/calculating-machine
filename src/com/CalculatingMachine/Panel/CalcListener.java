package com.CalculatingMachine.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private final JTextField inputField;
    private final JTextField operationsHistoryField;
    Field field;

    public CalcListener(JTextField inputField, JTextField operationsHistoryField) {
        this.inputField = inputField;
        this.operationsHistoryField = operationsHistoryField;
        field = new Field(this.inputField, this.operationsHistoryField);
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
        if (field.isThereInside(inputField, "Enter digits")) {
            field.clearField(inputField);
            field.setSymbol(inputField, button.getText());
        } else if (field.hasDot(button)) {
            field.deleteDot();
        } else if (!field.isContains(operationsHistoryField, "=")) {
            field.setSymbol(inputField, button.getText());
        }
    }

    private void saveOperandAndDefineOperator(CalcButton button) {
        if (!field.isThereInside(inputField, "") && !field.isThereOperands(inputField) && field.isThereInside(operationsHistoryField, "")) {
            saveOperand();
            saveOperator(button);
            field.moveStringTo(operationsHistoryField, button);
            field.clearField(inputField);
        }
    }

    private void outputCalculate(CalcButton button) {
        if (!field.isThereInside(operationsHistoryField, "") && !field.isThereInside(inputField, "") && !field.isContains(operationsHistoryField, "=")) {
            saveOperand();
            field.moveStringTo(operationsHistoryField, button);
            field.outputTheResult(calculate());

        }
    }

    private void clear() {
        CalcMemory.clear();
        field.clearField(operationsHistoryField);
        field.clearField(inputField);
    }

    private void installOrUninstall() {
        if (field.isThereInside(inputField, "Enter digits")) {
            field.clearField(inputField);
        }
        if (!field.isThereInside(inputField, "") && !field.isContains(operationsHistoryField, "=")) {
            if (field.isElementPosition(inputField, '-', 0)) {
                field.deleteFirstElement(inputField);
            } else {
                field.setSignNegative(inputField);
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

    private void saveOperator(CalcButton button){CalcMemory.setOperator(button.getText());}

    private void saveOperand() {CalcMemory.setOperand(inputField.getText());}

}

