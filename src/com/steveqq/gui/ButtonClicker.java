package com.steveqq.gui;

import com.steveqq.operations.MathOperations;
import com.steveqq.parse.RomanParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class ButtonClicker {
    private RomanParser mRomanParser;
    private MathOperations mMathOperations;
    public Map<JButton, Integer> buttonMap;

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
    protected plusClick plusClicker;
    protected mClick mClicker;
    protected mulClick mulClicker;
    protected subClick subClicker;
    protected backClick backClicker;
    protected divClick divClicker;
    protected eqClick eqClicker;
    protected cleanClick cleanClicker;
    //-----ACTION LISTENERS FOR BUTTONS-----//

    public ButtonClicker(GUI gui){
        mGui = gui;
        mRomanParser = new RomanParser();
        buttonMap = createButtonMap();
        mMathOperations = new MathOperations();

        //-----CREATE ACTION LISTENERS-----//
        iClicker = new iClick();
        vClicker = new vClick();
        xClicker = new xClick();
        lClicker = new lClick();
        cClicker = new cClick();
        dClicker = new dClick();
        plusClicker = new plusClick();
        mClicker = new mClick();
        mulClicker = new mulClick();
        subClicker = new subClick();
        backClicker = new backClick();
        divClicker = new divClick();
        eqClicker = new eqClick();
        cleanClicker = new cleanClick();
        //-----CREATE ACTION LISTENERS-----//

    }


    //-----INNER CLASSES OF ACTION LISTENER----//

    class iClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            iCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
            insertAssistant((JButton)ev.getSource());
        }
    }

    class vClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            vCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
            insertAssistant((JButton)ev.getSource());
        }
    }

    class xClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            xCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
            insertAssistant((JButton)ev.getSource());
        }
    }

    class lClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            lCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
            insertAssistant((JButton)ev.getSource());
        }
    }

    class cClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            cCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
            insertAssistant((JButton)ev.getSource());
        }
    }

    class dClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            dCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
            insertAssistant((JButton)ev.getSource());
        }
    }
    class plusClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            resetCalculator();
        }
    }

    class mClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            mCounter += 1;
            mGui.numberArea.append(ev.getActionCommand());
            insertAssistant((JButton)ev.getSource());
        }
    }

    class mulClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            resetCalculator();
        }
    }

    class subClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            resetCalculator();
        }
    }

    class backClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            JTextArea textArea = mGui.numberArea;
            if(!textArea.getText().equals("")) {
                String cropedString = textArea.getText().substring(0, textArea.getText().length() - 1);
                textArea.setText("");
                textArea.append(cropedString);
            }
        }
    }

    class divClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData(ev.getActionCommand().charAt(0));
            resetCalculator();
        }
    }

    class eqClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationData();
            if(mMathOperations.getElementsToCount().size() >= 2 && mMathOperations.getOperationSymbols().size() >= 1) {
                try {
                    mGui.numberArea.setText(mRomanParser.decimalToRoman(mMathOperations.doMath()));
                    mMathOperations.clearOperationData();
                } catch(IllegalArgumentException iae){
                    JOptionPane.showMessageDialog(GUI.frame,
                            "Result would be < 1, change second argument",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            mMathOperations.clearOperationData();
            resetCalculator();
        }
    }


    //-----INNER CLASSES OF ACTION LISTENER----//

    class cleanClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            mGui.numberArea.setText("");
            resetCalculator();
        }
    }

    public Map<JButton, Integer> createButtonMap(){
        ArrayList<JButton> buttonList = mGui.getButtonList();
        Map<JButton, Integer> btnMap = new HashMap<>();
        Map<JButton, Integer> result ;
        for(int i=0; i < buttonList.size(); i++) {
            if((i+1) % 2 == 1){
                btnMap.put(buttonList.get(i), (int)(1 * Math.pow(10, (i/2))));
            } else {
                btnMap.put(buttonList.get(i), (int)(5 * Math.pow(10, i - ((i+1)/2))));
            }
        }
        result = sortByValue(btnMap);
        return result;
    }

    public Map<JButton, Integer> sortByValue(Map<JButton, Integer> messyMap){
        List<Map.Entry<JButton, Integer>> listOfEntries = new ArrayList<>(messyMap.entrySet());
        Collections.sort(listOfEntries, new Comparator<Map.Entry<JButton, Integer>>() {
            @Override
            public int compare(Map.Entry<JButton, Integer> o1, Map.Entry<JButton, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });
        Map<JButton, Integer> result = new LinkedHashMap<>();
        for(Map.Entry entry : listOfEntries){
            result.put((JButton)entry.getKey(), (Integer)entry.getValue());
        }
        return result;
    }

    private void registerOperationData(Character operationSymbol){
        JTextArea textArea = mGui.numberArea;
        if(!textArea.getText().equals("")) {
            Integer decimalInsertion = mRomanParser.romanToDecimal(textArea.getText());
            mMathOperations.addElementsToCount(decimalInsertion);
            mMathOperations.addOperationSymbols(operationSymbol);
            textArea.setText("");
        }
    }

    private void registerOperationData(){
        JTextArea textArea = mGui.numberArea;
        if(!textArea.getText().equals("")) {
            Integer decimalInsertion = mRomanParser.romanToDecimal(textArea.getText());
            mMathOperations.addElementsToCount(decimalInsertion);
            textArea.setText("");
        }
    }

    private void resetCalculator(){
        iCounter = 0;
        vCounter = 0;
        xCounter = 0;
        lCounter = 0;
        cCounter = 0;
        dCounter = 0;
        mCounter = 0;
        for(JButton button : mGui.getButtonList()) {
            button.setEnabled(true);
        }
    }

    private void insertAssistant(JButton button){
        Integer buttonValue = buttonMap.get(button);
        if(mCounter == 3 || cCounter == 3 || xCounter == 3 || iCounter == 3){
            button.setEnabled(false);

        } else if(vCounter == 1 || lCounter == 1 || dCounter == 1){
            button.setEnabled(false);
        }

        for(Map.Entry entry : buttonMap.entrySet()) {
            if((Integer)entry.getValue() > buttonValue){
                switch(buttonValue){
                    case 1:
                        if(iCounter < 2){
                            if((Integer)entry.getValue() > 10){
                                JButton disable = (JButton) entry.getKey();
                                disable.setEnabled(false);
                            }
                        } else {
                            if ((Integer) entry.getValue() > buttonValue) {
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
                            if ((Integer) entry.getValue() > buttonValue) {
                                JButton disable = (JButton) entry.getKey();
                                disable.setEnabled(false);
                            }
                        }
                        break;
                    case 100:
                        if(cCounter >= 2){
                            if ((Integer) entry.getValue() > buttonValue) {
                                JButton disable = (JButton) entry.getKey();
                                disable.setEnabled(false);
                            }
                        }
                        break;
                    case 5:
                    case 50:
                    case 500:
                        if ((Integer) entry.getValue() > buttonValue) {
                            JButton disable = (JButton) entry.getKey();
                            disable.setEnabled(false);
                        }
                        break;
                    default:
                        break;

                }
            }
        }
    }


}
