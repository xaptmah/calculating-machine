package com.CalculatingMachine;

import com.CalculatingMachine.Panel.WindiowCM;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WindiowCM windiowCM = new WindiowCM();
                windiowCM.show();
            }
        });
    }
}
