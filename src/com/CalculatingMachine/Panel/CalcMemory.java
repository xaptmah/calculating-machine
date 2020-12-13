package com.CalculatingMachine.Panel;

import java.util.ArrayList;
import java.util.List;

public class CalcMemory{
    private static List<String> operands;
    private static List<String> operators;

    public CalcMemory(){
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void setOperand(String operand) {
        CalcMemory.operands.add(operand);
    }

    public double getOperand(int index) {
        return Double.parseDouble(operands.get(index));
    }

    public void setOperator(String operator) {
        CalcMemory.operators.add(operator);
    }

    public String getOperator(int index) {
        return operators.get(index);
    }
    public void clear(){
        operators.clear();
        operands.clear();
    }


}
