package com.CalculatingMachine.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class WindiowCM {


    private final JTextField output = new JTextField();
    private final JTextField output2 = new JTextField();




    public void addComponentsToWindiow(Container jPanel){


        jPanel.setBounds(0,0,240,340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        jPanel.revalidate();
        output2.setEditable(false);
        jPanel.add(output, getLocationTextField(7,20,1));
        jPanel.add(output2, getLocationTextField(7,20,0));
        getButtonListener(jPanel);




    }
    private  void getButtonListener(Container jPanel){
        int numberButton = 10;
        for(int i = 3; i < 6; i++){
            for(int y = 4; y > 1; y--){
                numberButton--;
                JButton numbers = new JButton((numberButton) + "");
                jPanel.add(numbers, getLocationButtonDigit(y,i));
                numbers.addActionListener(new BListener());
            }
        }
        JButton additionBtn = new JButton("хуйнаны");
        additionBtn.addActionListener(new BListener());
        jPanel.add(additionBtn);

        JButton calculate = new JButton( "=");
        jPanel.add(calculate , getLocationVerticalButton(5,3,2));
        calculate.addActionListener(new BListener());

        JButton subtract = new JButton("-");
        jPanel.add(subtract, getLocationButtonDigit(5,5));
        subtract.addActionListener(new BListener());

        JButton zero = new JButton("0");
        jPanel.add(zero, getLocationHorizontalButton(2,6,2));
        zero.addActionListener(new BListener());

        JButton sum = new JButton("+");
        jPanel.add(sum, getLocationButtonDigit(5,6));
        sum.addActionListener(new BListener());

        JButton dot = new JButton(".");
        jPanel.add(dot, getLocationButtonDigit(4,6));
        dot.addActionListener(new BListener());

        JButton clean = new JButton("C");
        jPanel.add(clean, getLocationButtonDigit(2,2));
        clean.addActionListener(new BListener());

        JButton divide = new JButton("/");
        jPanel.add(divide, getLocationButtonDigit(3,2));
        divide.addActionListener(new BListener());

        JButton multiply = new JButton("*");
        jPanel.add(multiply, getLocationButtonDigit(4,2));
        multiply.addActionListener(new BListener());

        JButton negativePositive = new JButton("±");
        jPanel.add(negativePositive, getLocationButtonDigit(5,2));
        negativePositive.addActionListener(new BListener());
    }

    private class BListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s1;
            s1 = ((JButton)e.getSource()).getText();


            //
            switch (s1){
                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
                case ".":
                    output.setText((output.getText() + s1)  );
                    break;
                case "+":
                    output2.setText(output2.getText() +output.getText() + s1);
                    output.setText("FUCK");
                    break;
                case "-":
                    output2.setText(output2.getText() +output.getText() + s1);
                    output.setText("FUCK");
                    break;
                case "=":
                    output.setText("FUCK");
                    break;
                case "*":
                    output2.setText(output2.getText() +output.getText() + s1);
                    output.setText("FUCK");
                    break;
                case "/":
                    output2.setText(output2.getText() +output.getText() + s1);
                    output.setText("FUCK");
                    break;
                case "C":
                    output2.setText("");
                    output.setText("");
                    break;
                case "±":
                    output2.setText("");
                    output.setText(output.getText() +"-");
                    break;


            }

        }
    }
    private GridBagConstraints getLocationTextField(int gr, int ipy,int gy){
        GridBagConstraints result = new GridBagConstraints();
        result.gridy = gy;
        result.gridwidth = gr;
        result.ipady = ipy;
        result.fill = GridBagConstraints.HORIZONTAL;
        return result;
    }


    private GridBagConstraints getLocationButtonDigit(int gx, int gy) {
        GridBagConstraints result = new GridBagConstraints();

        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        result.gridwidth = 1;
        result.fill = GridBagConstraints.HORIZONTAL;
        //result.anchor = GridBagConstraints.LINE_START;
        return result;
    }

    private GridBagConstraints getLocationVerticalButton(int gx, int gy, int gr/*, int ipy*/){
        GridBagConstraints result = new GridBagConstraints();
        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        result.gridheight = gr;
        //result.ipady = ipy;
        result.fill = GridBagConstraints.BOTH;

        return result;
    }
    private GridBagConstraints getLocationHorizontalButton(int gx, int gy, int gr/*, int ipy*/){
        GridBagConstraints result = new GridBagConstraints();
        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        result.gridwidth = gr;
        //result.ipady = ipy;
        result.fill = GridBagConstraints.HORIZONTAL;
        return result;
    }

    public void show(){
        JFrame window = new JFrame("Calculating Machine");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        addComponentsToWindiow(window.getContentPane());
        window.setVisible(true);
        window.pack();
        //window.setResizable(false);
    }
}
