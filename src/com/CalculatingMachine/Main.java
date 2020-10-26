package com.CalculatingMachine;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    private JFrame window;
    public Main(){
        window = new JFrame("Calculating Machine");
        window.setSize(280,340);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    //CalculatingMachine calculatingMachine = new CalculatingMachine();


}
