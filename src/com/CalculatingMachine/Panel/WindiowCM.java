package com.CalculatingMachine.Panel;

import com.CalculatingMachine.Panel.CalcButton.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class WindiowCM {


    private final JTextField output = new JTextField();
    private final JTextField output2 = new JTextField();


    public void addComponentsToWindiow(Container jPanel) {


        jPanel.setBounds(0, 0, 240, 340);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        jPanel.revalidate();
        output2.setEditable(false);
        jPanel.add(output, getLocationTextField(7, 20, 1));
        jPanel.add(output2, getLocationTextField(7, 20, 0));
        getButtonListener(jPanel);


    }

    private void getButtonListener(Container jPanel) {
        int numberButton = 10;
        for (int i = 3; i < 6; i++) {
            for (int y = 4; y > 1; y--) {
                addButton(jPanel, String.valueOf(--numberButton), y, i, Type.INPUT);
            }
        }
        addButtonVertical(jPanel,"=",5,3,2,Type.EQUAL);
        addButtonHorizontal(jPanel,"0",2,6,2,Type.INPUT);
        addButton(jPanel, "-", 5, 5, Type.OPERATION);
        addButton(jPanel, "+", 5, 6, Type.OPERATION);
        addButton(jPanel, ".", 4, 6, Type.INPUT);
        addButton(jPanel, "C", 2, 2, Type.CLEAR);
        addButton(jPanel, "/", 3, 2, Type.OPERATION);
        addButton(jPanel, "*", 4, 2, Type.OPERATION);
        addButton(jPanel, "±", 5, 2, Type.NEGATIVE);
    }

    private void addButton(Container jPanel, String text, int x, int y, Type type) {
        JButton subtract = new CalcButton(text, type);
        jPanel.add(subtract, getLocationButtonDigit(x, y));
        subtract.addActionListener(new CalcListener(output, output2));
    }
    private  void addButtonHorizontal(Container jPanel,String text,int gx, int gy, int gr,Type type){
        JButton subtract = new CalcButton(text, type);
        jPanel.add(subtract, getLocationHorizontalButton(gx,gy,gr));
        subtract.addActionListener(new CalcListener(output, output2));
    }
    private  void addButtonVertical(Container jPanel,String text,int gx, int gy, int gr,Type type){
        JButton subtract = new CalcButton(text, type);
        jPanel.add(subtract, getLocationVerticalButton(gx,gy,gr));
        subtract.addActionListener(new CalcListener(output, output2));
    }


    private GridBagConstraints getLocationTextField(int gr, int ipy, int gy) {
        GridBagConstraints result = new GridBagConstraints();
        result.gridy = gy;
        result.gridwidth = gr;
        result.ipady = ipy;
        result.fill = GridBagConstraints.HORIZONTAL;
        return result;
    }


    private GridBagConstraints getLocationButtonDigit(int gx, int gy) {
        GridBagConstraints result = new GridBagConstraints();
        getLocationButton(result,gx,gy);
        result.gridwidth = 1;
        result.fill = GridBagConstraints.HORIZONTAL;
        //result.anchor = GridBagConstraints.LINE_START;
        return result;
    }


    private GridBagConstraints getLocationVerticalButton(int gx, int gy, int gr) {
        GridBagConstraints result = new GridBagConstraints();
        getLocationButton(result,gx,gy);
        result.gridheight = gr;
        return result;
    }

    private GridBagConstraints getLocationHorizontalButton(int gx, int gy, int gr) {
        GridBagConstraints result = new GridBagConstraints();
        getLocationButton(result,gx,gy);
        result.gridwidth = gr;
        return result;
    }
    private void getLocationButton(GridBagConstraints result,int gx,int gy){
        result.gridx = gx;
        result.gridy = gy;
        result.ipady = 20;
        result.ipadx = 20;
        result.fill = GridBagConstraints.BOTH;
    }

    public void show() {
        JFrame window = new JFrame("Calculating Machine");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        addComponentsToWindiow(window.getContentPane());
        window.setVisible(true);
        window.pack();
        //window.setResizable(false);
    }
}
