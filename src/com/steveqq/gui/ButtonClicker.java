package com.steveqq.gui;

import com.steveqq.operations.MathOperations;
import com.steveqq.parse.RomanParser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class ButtonClicker {
    RomanParser romanParser = new RomanParser();
    MathOperations mathOperations = new MathOperations();
    class Iclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("I");
        }
    }

    class Vclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("V");
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
        }
    }

    class Plusclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            romanParser.romanToDecimal(GUI.numberArea.getText().toString());
            mathOperations.addElementsToCount(romanParser.romanToDecimal(GUI.numberArea.getText().toString()));
            mathOperations.addOperationSymbols('+');
            GUI.numberArea.setText("");
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
            romanParser.romanToDecimal(GUI.numberArea.getText().toString());
        }
    }

    class Subclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            romanParser.romanToDecimal(GUI.numberArea.getText().toString());
        }
    }

    class Backclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            String fullString = GUI.numberArea.getText().toString();
            String cropedString = fullString.substring(0, GUI.numberArea.getText().toString().length() - 1);
            GUI.numberArea.setText("");
            GUI.numberArea.append(cropedString);
        }
    }

    class Divclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            romanParser.romanToDecimal(GUI.numberArea.getText().toString());
        }
    }

    class Eqclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            mathOperations.doMath(mathOperations.getElementsToCount(), mathOperations.getOperationSymbols());
        }
    }
}
