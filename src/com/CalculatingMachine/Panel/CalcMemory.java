package com.CalculatingMachine.Panel;

import java.util.ArrayList;

public class CalcMemory{
    private static final ArrayList<String> operands = new ArrayList<>();
    private static final ArrayList<String> operators = new ArrayList<>();



    public static void setOperand(String operand) {
        CalcMemory.operands.add(operand);
    }

    public static double getOperand(int index) {
        return Double.parseDouble(operands.get(index));
    }

    public static void setOperator(String operator) {
        CalcMemory.operators.add(operator);
    }

    public static String getOperator(int index) {
        return operators.get(index);
    }
    public static void clear(){
        operators.clear();
        operands.clear();
    }


}
