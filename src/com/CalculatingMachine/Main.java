//This My first progect.
//@ Karpalov Dmitriy.  karpalovdmitrij@gmail.com


package com.CalculatingMachine;

import com.CalculatingMachine.Panel.WindowCM;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WindowCM windowCM = new WindowCM();
                windowCM.show();
            }
        });
    }
}
