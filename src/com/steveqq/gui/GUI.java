package com.steveqq.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by SteveQ on 2016-08-15.
 */
public class GUI {
    private JFrame frame;
    private JPanel textAreaWrapPanel, gridWrapPanel, eqWrapPanel;
    public static JTextArea numberArea;
    private JButton Ibutton, Vbutton, Xbutton, Lbutton, Cbutton, Dbutton, Mbutton,
                    plusButton, subButton, multButton, divButton, backButton, eqButton;
    private JMenuBar menuBar;
    private JMenu viewMenu;

    public void createGUI(){
        frame = new JFrame("Roman Calculator");

        menuBar = new JMenuBar();
        viewMenu = new JMenu("View");

        textAreaWrapPanel = new JPanel();
        textAreaWrapPanel.setLayout(new BorderLayout());
        textAreaWrapPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        numberArea = new JTextArea();
        numberArea.setBorder(BorderFactory.createLoweredBevelBorder());
        numberArea.setFont(new Font("monospace", 0, 16));
        numberArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        Ibutton = new JButton("I");
        Vbutton = new JButton("V");
        Xbutton = new JButton("X");
        Lbutton = new JButton("L");
        Cbutton = new JButton("C");
        Dbutton = new JButton("D");
        Mbutton = new JButton("M");
        plusButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        backButton = new JButton("<<<");


        gridWrapPanel = new JPanel();
        gridWrapPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        gridWrapPanel.setLayout(new GridLayout(4, 3, 5, 5));
        gridWrapPanel.add(Ibutton);
        gridWrapPanel.add(Vbutton);
        gridWrapPanel.add(Xbutton);
        gridWrapPanel.add(Lbutton);
        gridWrapPanel.add(Cbutton);
        gridWrapPanel.add(Dbutton);
        gridWrapPanel.add(plusButton);
        gridWrapPanel.add(Mbutton);
        gridWrapPanel.add(multButton);
        gridWrapPanel.add(subButton);
        gridWrapPanel.add(backButton);
        gridWrapPanel.add(divButton);

        eqWrapPanel = new JPanel();
        eqWrapPanel.setLayout(new BorderLayout());
        eqWrapPanel.add(eqButton);
        eqWrapPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
        frame.add(BorderLayout.SOUTH, eqWrapPanel);

        menuBar.add(viewMenu);
        frame.setJMenuBar(menuBar);
        textAreaWrapPanel.add(numberArea);
        frame.add(BorderLayout.CENTER, gridWrapPanel);


        frame.getContentPane().add(BorderLayout.NORTH, textAreaWrapPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
