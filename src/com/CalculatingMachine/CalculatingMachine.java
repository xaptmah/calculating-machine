package com.CalculatingMachine;

import com.CalculatingMachine.Panel.Operand;
import com.CalculatingMachine.Panel.Operator;

import java.util.ArrayList;
import java.util.List;

public class CalculatingMachine {
    private List<Operand> operands;
    private List<Operator> operators;

    public CalculatingMachine(){
        this.operands = new ArrayList<>();
        this.operators = new ArrayList<>();
    }
    public Operand getOperand(int num){

        return operands.isEmpty() ? null : operands.get(num);
    }
    public Operator getOperator(){
        return  operators.isEmpty() ? null : operators.get(0);
    }
    public void setOperand(Operand operand) {
        this.operands.add(operand);
    }

    public void setOperator(Operator operators) {
        this.operators.add(operators);
    }
    public Double reshenie(){
        double i = getOperand(0).getOper();

        double zi  = getOperand(0).getOper();
        return i+zi;
    }

    public int xui4estvo(){
        return operands.size();
    }

}