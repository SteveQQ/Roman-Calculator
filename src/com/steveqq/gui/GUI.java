package com.steveqq.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by SteveQ on 2016-08-15.
 */
public class GUI {
    protected static JFrame frame;
    private JPanel textAreaWrapPanel, gridWrapPanel, eqWrapPanel, cleanWrapPanel, southButtonsWrapper;
    protected static JTextArea numberArea;
    protected static JButton iButton, vButton, xButton, lButton, cButton, dButton, mButton,
                    plusButton, subButton, mulButton, divButton, backButton, eqButton, cleanButton;
    private JMenuBar menuBar;
    private JMenu viewMenu;
    private ButtonClicker buttonClicker;
    private ButtonClicker.iClick iClicker;
    private ButtonClicker.vClick vClicker;
    private ButtonClicker.xClick xClicker;
    private ButtonClicker.lClick lClicker;
    private ButtonClicker.cClick cClicker;
    private ButtonClicker.dClick dClicker;
    private ButtonClicker.plusClick plusClicker;
    private ButtonClicker.mClick mClicker;
    private ButtonClicker.mulClick mulClicker;
    private ButtonClicker.subClick subClicker;
    private ButtonClicker.backClick backClicker;
    private ButtonClicker.divClick divClicker;
    private ButtonClicker.eqClick eqClicker;
    private ButtonClicker.cleanClick cleanClicker;

    public GUI(){

        frame = new JFrame("Roman Calculator");

        textAreaWrapPanel = new JPanel();
        gridWrapPanel = new JPanel();
        cleanWrapPanel = new JPanel();
        eqWrapPanel = new JPanel();
        southButtonsWrapper = new JPanel();

        numberArea = new JTextArea();

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

        menuBar = new JMenuBar();
        viewMenu = new JMenu("View");

        buttonClicker = new ButtonClicker();
        iClicker = buttonClicker.new iClick();
        vClicker = buttonClicker.new vClick();
        xClicker = buttonClicker.new xClick();
        lClicker = buttonClicker.new lClick();
        cClicker = buttonClicker.new cClick();
        dClicker = buttonClicker.new dClick();
        plusClicker = buttonClicker.new plusClick();
        mClicker = buttonClicker.new mClick();
        mulClicker = buttonClicker.new mulClick();
        subClicker = buttonClicker.new subClick();
        backClicker = buttonClicker.new backClick();
        divClicker = buttonClicker.new divClick();
        eqClicker = buttonClicker.new eqClick();
        cleanClicker = buttonClicker.new cleanClick();
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

        iButton.addActionListener(iClicker);
        vButton.addActionListener(vClicker);
        xButton.addActionListener(xClicker);
        lButton.addActionListener(lClicker);
        cButton.addActionListener(cClicker);
        dButton.addActionListener(dClicker);
        plusButton.addActionListener(plusClicker);
        mButton.addActionListener(mClicker);
        mulButton.addActionListener(mulClicker);
        subButton.addActionListener(subClicker);
        backButton.addActionListener(backClicker);
        divButton.addActionListener(divClicker);
        eqButton.addActionListener(eqClicker);
        cleanButton.addActionListener(cleanClicker);

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

}
