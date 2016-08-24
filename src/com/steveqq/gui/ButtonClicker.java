package com.steveqq.gui;

import com.steveqq.operations.MathOperations;
import com.steveqq.parse.RomanParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class ButtonClicker {
    private RomanParser mRomanParser;
    private MathOperations mMathOperations;
    private ArrayList<Integer> insertedNumbers;

    //-----GUI THAT BUTTON CLICKER OPERATES ON-----//
    private GUI mGui;

    //-----COUNTERS FOR EACH BUTTON-----//
    protected Integer iCounter = 0;
    protected Integer vCounter = 0;
    protected Integer xCounter = 0;
    protected Integer lCounter = 0;
    protected Integer cCounter = 0;
    protected Integer dCounter = 0;
    protected Integer mCounter = 0;
    //-----COUNTERS FOR EACH BUTTON-----//


    //-----ACTION LISTENERS FOR BUTTONS-----//
    protected iClick iClicker;
    protected vClick vClicker;
    protected xClick xClicker;
    protected lClick lClicker;
    protected cClick cClicker;
    protected dClick dClicker;
    /*protected plusClick plusClicker;
    protected mClick mClicker;
    protected mulClick mulClicker;
    protected subClick subClicker;
    protected backClick backClicker;
    protected divClick divClicker;
    protected eqClick eqClicker;
    protected cleanClick cleanClicker;*/
    //-----ACTION LISTENERS FOR BUTTONS-----//

    public ButtonClicker(GUI gui){
        mGui = gui;

        //-----CREATE ACTION LISTENERS-----//
        iClicker = new iClick();
        vClicker = new vClick();
        xClicker = new xClick();
        lClicker = new lClick();
        cClicker = new cClick();
        dClicker = new dClick();
        /*plusClicker = new plusClick();
        mClicker = new mClick();
        mulClicker = new mulClick();
        subClicker = new subClick();
        backClicker = new backClick();
        divClicker = new divClick();
        eqClicker = new eqClick();
        cleanClicker = new cleanClick();*/
        //-----CREATE ACTION LISTENERS-----//

        mRomanParser = new RomanParser();
        insertedNumbers = new ArrayList<>();
    }


    //-----INNER CLASSES OF ACTION LISTENER----//

    class iClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            iCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
        }
    }

    class vClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            vCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
        }
    }

    class xClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            xCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
        }
    }

    class lClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            lCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
        }
    }

    class cClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            cCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
        }
    }

    class dClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            dCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
        }
    }
/*
    class plusClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            cleanCounters();
        }
    }

    class mClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            mCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
        }
    }

    class mulClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            cleanCounters();
        }
    }

    class subClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            cleanCounters();
        }
    }

    class backClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            String fullString = mGui.numberArea.getText().toString();
            if(!fullString.equals("")) {
                String cropedString = fullString.substring(0, mGui.numberArea.getText().toString().length() - 1);
                GUI.numberArea.setText("");
                GUI.numberArea.append(cropedString);
            }
        }
    }

    class divClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            cleanCounters();
        }
    }

    class eqClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet();
            if(MathOperations.elementsToCount.size() >= 2 && MathOperations.operationSymbols.size() >= 1) {
                try {
                    GUI.numberArea.setText(mRomanParser.decimalToRoman(MathOperations.doMath()));
                    MathOperations.clearOperationData();
                } catch(IllegalArgumentException iae){
                    JOptionPane.showMessageDialog(GUI.frame,
                            "Result would be < 1, change second argument",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            MathOperations.clearOperationData();
            cleanCounters();
        }
    }

    class cleanClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.setText("");
            MathOperations.clearOperationData();
            cleanCounters();
        }
    }

    //-----INNER CLASSES OF ACTION LISTENER----//

    private void registerOperationData(Character operationSymbol){
        String textInArea = mGui.numberArea.getText();
        if(!textInArea.equals("")) {
            Integer decimalInsertion = mRomanParser.romanToDecimal(textInArea);
            mMathOperations.addElementsToCount(decimalInsertion);
            mMathOperations.addOperationSymbols(operationSymbol);
            GUI.numberArea.setText("");
        }
    }

    private void registerOperationSet(){
        if(!mGui.numberArea.getText().toString().equals("")) {
            Integer decimal = mRomanParser.romanToDecimal(mGui.numberArea.getText().toString());
            MathOperations.elementsToCount.add(decimal);
            GUI.numberArea.setText("");
        }
    }
*/

}
