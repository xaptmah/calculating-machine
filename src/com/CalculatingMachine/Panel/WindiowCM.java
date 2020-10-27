package com.CalculatingMachine.Panel;

import javax.swing.JFrame;


public class WindiowCM {
    private JFrame window = new JFrame("Calculating Machine");
    public WindiowCM(){

        window.setSize(280,340);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.add(new Buttons());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void show(){
        window.setVisible(true);
    }
}
