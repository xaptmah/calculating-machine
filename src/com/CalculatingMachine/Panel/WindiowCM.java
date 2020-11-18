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


    private JTextField output = new JTextField();
    private JButton additionBtn = new JButton("хуйнаны");
    private JButton calculate = new JButton( "=");
    private JButton subtract = new JButton("-");
    private JButton zero = new JButton("0");
    private JButton sum = new JButton("+");
    private JButton comma = new JButton(",");
    private JButton clean = new JButton("C");
    private JButton divide = new JButton("/");
    private JButton multiply = new JButton("*");
    private JButton negativePositive = new JButton("±");


    public void addComponentsToWindiow(Container jPanel){


        jPanel.setBounds(0,0,240,340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        jPanel.revalidate();
        //output.setEditable(false);
        jPanel.add(output, getLocationTextField(7,20));

         int number = 10;
        for(int i = 2; i < 5; i++){
            for(int y = 4; y > 1; y--){
                number--;
                JButton numbers = new JButton((number) + "");
                jPanel.add(numbers, getLocationButtonDigit(y,i));
                numbers.addActionListener(new BListener());
            }
        }
        additionBtn.addActionListener(new BListener());
        jPanel.add(additionBtn);

        jPanel.add(calculate , getLocationVerticalButton(5,2,2));
        calculate.addActionListener(new BListener());

        jPanel.add(subtract, getLocationButtonDigit(5,4));
        subtract.addActionListener(new BListener());

        jPanel.add(zero, getLocationHorizontalButton(2,5,2));
        zero.addActionListener(new BListener());

        jPanel.add(sum, getLocationButtonDigit(5,5));
        sum.addActionListener(new BListener());

        jPanel.add(comma, getLocationButtonDigit(4,5));
        comma.addActionListener(new BListener());

        jPanel.add(clean, getLocationButtonDigit(2,1));
        clean.addActionListener(new BListener());

        jPanel.add(divide, getLocationButtonDigit(3,1));
        divide.addActionListener(new BListener());

        jPanel.add(multiply, getLocationButtonDigit(4,1));
        multiply.addActionListener(new BListener());

        jPanel.add(negativePositive, getLocationButtonDigit(5,1));
        negativePositive.addActionListener(new BListener());

    }
    private class BListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s1, s2;
            s1 = ((JButton)e.getSource()).getText();

            output.setText(output.getText() + s1);
        }
    }
    private GridBagConstraints getLocationTextField(int gr, int ipy){
        GridBagConstraints result = new GridBagConstraints();
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
