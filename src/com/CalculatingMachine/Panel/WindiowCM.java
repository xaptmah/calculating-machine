package com.CalculatingMachine.Panel;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class WindiowCM {



    public static void addComponentsToWindiow(Container jPanel){


        jPanel.setBounds(0,0,240,340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);

        GridBagConstraints constraints = new GridBagConstraints();
        //constraints1.weightx = 0;
        //constraints.weighty = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        //constraints.anchor = GridBagConstraints.NORTH;
        //constraints1.gridheight = 3;
        //constraints1.gridwidth = 6;

        jPanel.add(new OutPanel(), constraints);


        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.ipady = 40;
        constraints2.weightx = 0.0;
        constraints2.gridwidth = 3;
        constraints2.gridx = 0;
        constraints2.gridy = 1;

        jPanel.add(new Buttons(), constraints2);
        jPanel.revalidate();
    }
    public void show(){
        JFrame window = new JFrame("Calculating Machine");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        addComponentsToWindiow(window.getContentPane());
        window.setVisible(true);
        window.pack();
        window.setResizable(false);
    }
}
