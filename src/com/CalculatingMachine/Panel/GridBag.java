package com.CalculatingMachine.Panel;


import java.awt.GridBagConstraints;

public class GridBag extends GridBagConstraints {

    GridBag (int gx, int gy, String text){

        getLocationElement(gx,gy,text);
    }
    public void getLocationElement(int gx, int gy, String text) {
        gridx = gx;
        gridy = gy;
        ipady = 20;
        ipadx = 20;
        buttonSize(text);
        fill = GridBagConstraints.BOTH;

    }

    private void buttonSize(String text) {
        switch (text) {
            case "=":
                gridheight = 2;
                break;
            case "0":
                gridwidth = 2;
                break;
            case "Enter digits":
                gridwidth = 7;
                break;
            default:
                gridwidth = 1;
                break;
        }

    }
}
