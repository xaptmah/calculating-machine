package com.CalculatingMachine.Panel;

public class Operand {


    double oper = 0.0;

    public Operand(String value){
        oper = Double.parseDouble(value);
    }



    public double getOper() {
        return oper;
    }
}
