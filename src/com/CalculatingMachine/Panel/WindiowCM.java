package com.CalculatingMachine.Panel;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class WindiowCM {



    public void addComponentsToWindiow(Container jPanel){


        jPanel.setBounds(0,0,240,340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        jPanel.revalidate();

        JTextField output = new JTextField();
        //output.setEditable(false);
        jPanel.add(output, getLocationTextField(7,20));

        int number = 10;
        for(int i = 1; i < 4; i++){
            for(int y = 4; y > 1; y--){
                number--;
                jPanel.add(new Button((number) + ""), getLocationButtonDigit(y,i));
            }
        }


        jPanel.add(new Button( "+"), getLocationVerticalButton(5,1,2));
        jPanel.add(new Button( "-"), getLocationVerticalButton(5,3,2));


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
        result.fill = GridBagConstraints.VERTICAL;
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
