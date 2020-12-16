package com.CalculatingMachine.Panel;

import javax.swing.*;

public class Field {
    private final JTextField inputField;
    private final JTextField operationsHistoryField;
    public Field(JTextField inputField, JTextField operationsHistoryField){
        this.inputField = inputField;
        this.operationsHistoryField = operationsHistoryField;

    }

    int lastPosition(JTextField field) {
        return field.getText().length() - 1;
    }

    boolean isThereOperands(JTextField field) {
        return "Enter digits".equals(field.getText());
    }

    void clearField(JTextField inputField) {
        inputField.setText("");
    }

    void setSignNegative(JTextField inputField) {inputField.setText("-" + inputField.getText());}

    void deleteFirstElement(JTextField inputField) {inputField.setText(inputField.getText().substring(1));}

    void outputTheResult(String result) {
        inputField.setText(result);
        operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText());
    }
    boolean isElementPosition(JTextField field, char element, int position) {
        return element == field.getText().charAt(position);
    }

    void deleteDot() {
        if (dotEndElement()) {
            inputField.setText(inputField.getText().substring(0, lastPosition(inputField)));
        }
    }

    private boolean dotEndElement() {
        return isElementPosition(inputField, '.', lastPosition(inputField));
    }

    boolean hasDot(CalcButton button) {return inputField.getText().contains(".") && button.getText().contains(".");}

    void setSymbol(JTextField field, String button) {field.setText(field.getText() + button);}

    boolean isThereInside(JTextField field, String element) {
        return element.equals(field.getText());
    }

    void moveStringTo(JTextField operationsHistoryField, CalcButton button) {
        operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText() + button.getText());
    }

    boolean isContains(JTextField operationsHistoryField, String element) {
        return operationsHistoryField.getText().contains(element);
    }

}
