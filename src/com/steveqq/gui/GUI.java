package com.steveqq.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveQ on 2016-08-15.
 */
public class GUI {
    protected static JFrame frame;
    private JPanel textAreaWrapPanel, gridWrapPanel, eqWrapPanel, cleanWrapPanel, southButtonsWrapper;
    protected JTextArea numberArea;
    protected JButton iButton, vButton, xButton, lButton, cButton, dButton, mButton,
                    plusButton, subButton, mulButton, divButton, backButton, eqButton, cleanButton;
    private JMenuBar menuBar;
    private JMenu viewMenu;
    private ButtonClicker buttonClicker;
    public ArrayList<JButton> buttonList;
    public Map<JButton, Integer> buttonMap;

    public GUI(){

        frame = new JFrame("Roman Calculator");
        buttonClicker = new ButtonClicker(this);
        buttonList = new ArrayList<>();

        //-----CREATING PANELS-----//
        textAreaWrapPanel = new JPanel();
        gridWrapPanel = new JPanel();
        cleanWrapPanel = new JPanel();
        eqWrapPanel = new JPanel();
        southButtonsWrapper = new JPanel();
        //-----CREATING PANELS-----//


        //-----CREATING BUTTONS-----//
        iButton = new JButton("I");
        vButton = new JButton("V");
        xButton = new JButton("X");
        lButton = new JButton("L");
        cButton = new JButton("C");
        dButton = new JButton("D");
        plusButton = new JButton("+");
        mButton = new JButton("M");
        mulButton = new JButton("*");
        subButton = new JButton("-");
        backButton = new JButton("<<<");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        cleanButton = new JButton("CLEAN");

        buttonList.add(iButton);
        buttonList.add(vButton);
        buttonList.add(xButton);
        buttonList.add(lButton);
        buttonList.add(cButton);
        buttonList.add(dButton);
        buttonList.add(mButton);

        iButton.addActionListener(buttonClicker.iClicker);
        vButton.addActionListener(buttonClicker.vClicker);
        xButton.addActionListener(buttonClicker.xClicker);
        lButton.addActionListener(buttonClicker.lClicker);
        cButton.addActionListener(buttonClicker.cClicker);
        dButton.addActionListener(buttonClicker.dClicker);
        /*plusButton.addActionListener(buttonClicker.plusClicker);
        mButton.addActionListener(buttonClicker.mClicker);
        mulButton.addActionListener(buttonClicker.mulClicker);
        subButton.addActionListener(buttonClicker.subClicker);
        backButton.addActionListener(buttonClicker.backClicker);
        divButton.addActionListener(buttonClicker.divClicker);
        eqButton.addActionListener(buttonClicker.eqClicker);
        cleanButton.addActionListener(buttonClicker.cleanClicker);*/

        iButton.setToolTipText("1");
        vButton.setToolTipText("5");
        xButton.setToolTipText("10");
        lButton.setToolTipText("50");
        cButton.setToolTipText("100");
        dButton.setToolTipText("500");
        mButton.setToolTipText("1000");
        //-----CREATING BUTTONS------//


        //-----CREATING MENU BAR-----//
        menuBar = new JMenuBar();
        viewMenu = new JMenu("View");
        //-----CREATING MENU BAR-----//

        numberArea = new JTextArea();
        buttonMap = new HashMap<>();

    }


    public void createGUI(){

        textAreaWrapPanel.setLayout(new BorderLayout());
        textAreaWrapPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        numberArea.setBorder(BorderFactory.createLoweredBevelBorder());
        numberArea.setFont(new Font("monospace", 0, 16));
        numberArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        numberArea.setEditable(false);

        gridWrapPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        gridWrapPanel.setLayout(new GridLayout(4, 3, 5, 5));

        southButtonsWrapper.setLayout(new BoxLayout(southButtonsWrapper, BoxLayout.Y_AXIS));

        gridWrapPanel.add(iButton);
        gridWrapPanel.add(vButton);
        gridWrapPanel.add(xButton);
        gridWrapPanel.add(lButton);
        gridWrapPanel.add(cButton);
        gridWrapPanel.add(dButton);
        gridWrapPanel.add(plusButton);
        gridWrapPanel.add(mButton);
        gridWrapPanel.add(mulButton);
        gridWrapPanel.add(subButton);
        gridWrapPanel.add(backButton);
        gridWrapPanel.add(divButton);

        eqWrapPanel.setLayout(new BorderLayout());
        eqWrapPanel.add(eqButton);
        eqWrapPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
        cleanWrapPanel.setLayout(new BorderLayout());
        cleanWrapPanel.add(cleanButton);
        cleanWrapPanel.setBorder(new EmptyBorder(0, 5, 5, 5));

        southButtonsWrapper.add(eqWrapPanel);
        southButtonsWrapper.add(cleanWrapPanel);
        frame.add(BorderLayout.SOUTH, southButtonsWrapper);

        menuBar.add(viewMenu);
        frame.setJMenuBar(menuBar);
        textAreaWrapPanel.add(numberArea);
        frame.add(BorderLayout.CENTER, gridWrapPanel);


        frame.getContentPane().add(BorderLayout.NORTH, textAreaWrapPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void createButtonMap(){
        for(int i=0; i < buttonList.size(); i++) {
            if((i+1) % 2 == 1){
                buttonMap.put(buttonList.get(i), (int)(1 * Math.pow(10, (i/2))));
            } else {
                buttonMap.put(buttonList.get(i), (int)(5 * Math.pow(10, i - ((i+1)/2))));
            }
        }
    }

    /*private void resetCalculator(){
        buttonClicker.iCounter = 0;
        buttonClicker.vCounter = 0;
        buttonClicker.xCounter = 0;
        buttonClicker.lCounter = 0;
        buttonClicker.cCounter = 0;
        buttonClicker.dCounter = 0;
        buttonClicker.mCounter = 0;
        for(Map.Entry entry : buttonMap.entrySet()) {
            JButton disable = (JButton) entry.getKey();
            disable.setEnabled(true);
        }
    }
    private void insertAssistant(JButton button){
        if(mCounter == 3 || cCounter == 3 || xCounter == 3 || iCounter == 3){
            button.setEnabled(false);

        } else if(vCounter == 1 || lCounter == 1 || dCounter == 1){
            button.setEnabled(false);
        }

        for(Map.Entry entry : buttonMap.entrySet()) {
            if((Integer)entry.getValue() > buttonMap.get(button)){
                switch(buttonMap.get(button)){
                    case 1:
                        if(iCounter < 2){
                            if((Integer)entry.getValue() > 10){
                                JButton disable = (JButton) entry.getKey();
                                disable.setEnabled(false);
                            }
                        } else {
                            if ((Integer) entry.getValue() > buttonMap.get(button)) {
                                JButton disable = (JButton) entry.getKey();
                                disable.setEnabled(false);
                            }
                        }
                        break;
                    case 10:
                        if(xCounter < 2){
                            if((Integer)entry.getValue() > 100){
                                JButton disable = (JButton) entry.getKey();
                                disable.setEnabled(false);
                            }
                        } else {
                            if ((Integer) entry.getValue() > buttonMap.get(button)) {
                                JButton disable = (JButton) entry.getKey();
                                disable.setEnabled(false);
                            }
                        }
                        break;
                    case 100:
                        break;
                    case 5:
                    case 50:
                    case 500:
                        if ((Integer) entry.getValue() > buttonMap.get(button)) {
                            JButton disable = (JButton) entry.getKey();
                            disable.setEnabled(false);
                        }
                        break;
                    default:
                        break;

                }
            }
        }
    }*/
}
