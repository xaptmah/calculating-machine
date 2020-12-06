package com.CalculatingMachine.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CalcListener implements ActionListener {

    private final JTextField inputField;
    private final JTextField operationsHistoryField;
    private List<String> operands;
    //private List<Operator> operators;

    public CalcListener(JTextField inputField, JTextField operationsHistoryField, List<String> operands) {
        this.inputField = inputField;
        this.operationsHistoryField = operationsHistoryField;
       this.operands = operands;
       // this.operators = new ArrayList<>();


    }



    public void actionPerformed(ActionEvent e) {
        CalcButton button = ((CalcButton) e.getSource());
        switch (button.TYPE) {
            case INPUT:

                if ("Enter digits".equals(inputField.getText())){
                    inputField.setText("");
                    inputField.setText(inputField.getText() + button.getText());
                    zapolnenie(inputField.getText());
                    System.out.println("позиция 0 "+nakinutinaventilyator());
                    System.out.println("заполнение списка "+skolkoderma());

                }else if (inputField.getText().contains(".") && button.getText().contains(".") ){

                }else {
                    inputField.setText(inputField.getText() + button.getText());
                    operands.add(inputField.getText());
                    System.out.println("позиция 0 "+operands.get(0));
                    System.out.println("заполнение списка "+operands.size());
                }
                break;
            case OPERATION:
                if (operationsHistoryField.getText().equals("")){
                    //operands.add(inputField.getText());
                    //System.out.println("позиция1 "+operands.get(0));
                    //System.out.println("заполнение списка "+operands.size());
                    operationsHistoryField.setText(operationsHistoryField.getText() + inputField.getText() + button.getText());
                    inputField.setText("");
                }else if((operationsHistoryField.getText()).contains("=")){
                    operationsHistoryField.setText("");
                    operationsHistoryField.setText(inputField.getText() + button.getText());
                    inputField.setText("");
                }else {
                    operationsHistoryField.setText(operationsHistoryField.getText());
                    //output.setText(String.valueOf((output2.getText()).compareTo("*")));
                }



                break;
            case EQUAL:
                //output2.setText(output2.getText() + output.getText());
                if(!(operationsHistoryField.getText()).contains("=")){
                    //operands.add(inputField.getText());
                    //System.out.println("заполнение списка "+operands.size());
                    //System.out.println("позиция2 "+operands.get(1));
                    operationsHistoryField.setText(operationsHistoryField.getText()+ inputField.getText());
                    inputField.setText(computation(operationsHistoryField.getText()));
                    operationsHistoryField.setText(operationsHistoryField.getText()+ "=" + computation(operationsHistoryField.getText()));
                }else {
                    operationsHistoryField.setText(operationsHistoryField.getText());
                }


                //
                break;
            case CLEAR:
                //operands.clear();
                operationsHistoryField.setText("");
                inputField.setText("");

                break;
            case NEGATIVE:
                if ("Enter digits".equals(inputField.getText())){
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

    }//output.setText(task);/**/
    private void zapolnenie (String govnoebanoe){
        operands.add(govnoebanoe);
    }
    private String nakinutinaventilyator(){
        return operands.get(0);
    }
    private int skolkoderma(){
        return operands.size();
    }






    private String computation(String task){
        if('-' == task.charAt(0)){
            if(task.substring(1).contains("-")){
                return String.valueOf(Double.parseDouble(("-"+task.substring(1,task.substring(1).indexOf('-')+1))) - Double.parseDouble(task.substring(task.substring(1).indexOf('-')+2)));
            }
        }else if(task.contains("-")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('-'))) - Double.parseDouble(task.substring(task.indexOf('-') + 1)));
        }else if (task.contains("+")) {
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('+'))) + Double.parseDouble(task.substring(task.indexOf('+') + 1)));
        }else if (task.contains("/")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('/'))) / Double.parseDouble(task.substring(task.indexOf('/') + 1)));
        }else if (task.contains("*")){
            return String.valueOf(Double.parseDouble(task.substring(0,task.indexOf('*'))) * Double.parseDouble(task.substring(task.indexOf('*') + 1)));
        }
        return task;
    }

}

