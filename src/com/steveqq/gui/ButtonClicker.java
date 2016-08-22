package com.steveqq.gui;

import com.steveqq.operations.MathOperations;
import com.steveqq.parse.RomanParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class ButtonClicker {
    private RomanParser romanParser = new RomanParser();
    private Map<JButton, Integer> buttonMap;
    private Integer iCounter = 0;
    private Integer vCounter = 0;
    private Integer xCounter = 0;
    private Integer lCounter = 0;
    private Integer cCounter = 0;
    private Integer dCounter = 0;
    private Integer mCounter = 0;

    protected ButtonClicker(){
        buttonMap = new HashMap<>();
        buttonMap.put(GUI.iButton, 1);
        buttonMap.put(GUI.vButton, 5);
        buttonMap.put(GUI.xButton, 10);
        buttonMap.put(GUI.lButton, 50);
        buttonMap.put(GUI.cButton, 100);
        buttonMap.put(GUI.dButton, 500);
        buttonMap.put(GUI.mButton, 1000);
    }

    private void cleanCounters(){
        iCounter = 0;
        vCounter = 0;
        xCounter = 0;
        lCounter = 0;
        cCounter = 0;
        dCounter = 0;
        mCounter = 0;
        for(Map.Entry entry : buttonMap.entrySet()) {
            JButton disable = (JButton) entry.getKey();
            disable.setEnabled(true);
        }
    }

    class iClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            iCounter += 1;
            GUI.numberArea.append("I");
            insertAssistant(GUI.iButton);
        }
    }

    class vClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            vCounter += 1;
            GUI.numberArea.append("V");
            insertAssistant(GUI.vButton);
        }
    }

    class xClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            xCounter += 1;
            GUI.numberArea.append("X");
            insertAssistant(GUI.xButton);
        }
    }

    class lClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            lCounter += 1;
            GUI.numberArea.append("L");
            insertAssistant(GUI.lButton);
        }
    }

    class cClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            cCounter += 1;
            GUI.numberArea.append("C");
            insertAssistant(GUI.cButton);
        }
    }

    class dClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            dCounter += 1;
            GUI.numberArea.append("D");
            insertAssistant(GUI.dButton);
        }
    }

    class plusClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('+');
            cleanCounters();
        }
    }

    class mClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            mCounter += 1;
            GUI.numberArea.append("M");
            insertAssistant(GUI.mButton);
        }
    }

    class mulClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('*');
            cleanCounters();
        }
    }

    class subClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('-');
            cleanCounters();
        }
    }

    class backClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            String fullString = GUI.numberArea.getText().toString();
            if(!fullString.equals("")) {
                String cropedString = fullString.substring(0, GUI.numberArea.getText().toString().length() - 1);
                GUI.numberArea.setText("");
                GUI.numberArea.append(cropedString);
            }
        }
    }

    class divClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('/');
            cleanCounters();
        }
    }

    class eqClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet();
            if(MathOperations.elementsToCount.size() >= 2 && MathOperations.operationSymbols.size() >= 1) {
                try {
                    GUI.numberArea.setText(romanParser.decimalToRoman(MathOperations.doMath()));
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

    private void registerOperationSet(Character operation){
        if(!GUI.numberArea.getText().toString().equals("")) {
            Integer decimal = romanParser.romanToDecimal(GUI.numberArea.getText().toString());
            MathOperations.elementsToCount.add(decimal);
            MathOperations.operationSymbols.add(operation);
            GUI.numberArea.setText("");
        }
    }

    private void registerOperationSet(){
        if(!GUI.numberArea.getText().toString().equals("")) {
            Integer decimal = romanParser.romanToDecimal(GUI.numberArea.getText().toString());
            MathOperations.elementsToCount.add(decimal);
            GUI.numberArea.setText("");
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
    }
}
