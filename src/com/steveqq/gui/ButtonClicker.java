package com.steveqq.gui;

import com.steveqq.operations.MathOperations;
import com.steveqq.parse.RomanParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class ButtonClicker {
    private RomanParser romanParser = new RomanParser();
    private Map<JButton, Integer> buttonMap;

    public ButtonClicker(){
        buttonMap = new HashMap<>();
        buttonMap.put(GUI.Ibutton, 1);
        buttonMap.put(GUI.Vbutton, 5);
        buttonMap.put(GUI.Xbutton, 10);
        buttonMap.put(GUI.Lbutton, 50);
        buttonMap.put(GUI.Cbutton, 100);
        buttonMap.put(GUI.Dbutton, 500);
        buttonMap.put(GUI.Mbutton, 1000);
    }

    class Iclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("I");
            insertAssistant(romanParser.getRomanValues().get(ev.getActionCommand().charAt(0)));
        }
    }

    class Vclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("V");
            GUI.Vbutton.setEnabled(false);
        }
    }

    class Xclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("X");
        }
    }

    class Lclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("L");
            GUI.Lbutton.setEnabled(false);
        }
    }

    class Cclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("C");
        }
    }

    class Dclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("D");
            insertAssistant(romanParser.getRomanValues().get(ev.getActionCommand().charAt(0)));
        }
    }

    class Plusclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('+');
        }
    }

    class Mclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("M");
        }
    }

    class Multclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('*');
        }
    }

    class Subclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('-');
        }
    }

    class Backclick implements ActionListener {
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

    class Divclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet('/');
        }
    }

    class Eqclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            registerOperationSet();
            if(MathOperations.elementsToCount.size() >= 2) {
                GUI.numberArea.setText(romanParser.decimalToRoman(MathOperations.doMath()));
                MathOperations.clearOperationData();
            }
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

    private void insertAssistant(Integer button){
        for(Map.Entry entry : buttonMap.entrySet()){
            if(button < (Integer)entry.getValue()){
                JButton disable = (JButton)entry.getKey();
                disable.setEnabled(false);
            }
        }
    }
}
