package com.CalculatingMachine.Panel;

import javax.swing.JButton;

public class CalcButton extends JButton {
    public enum Type {
        INPUT, OPERATION, EQUAL, CLEAR, NEGATIVE
    }

    public final Type TYPE;

    public CalcButton(String text, Type type) {
        super(text);
        this.TYPE = type;
    }
}
