package com.steveqq.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class ButtonClicker {
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
            GUI.numberArea.append("+");
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
            GUI.numberArea.append("*");
        }
    }

    class Subclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("-");
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
            GUI.numberArea.append("/");
        }
    }

    class Eqclick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev){
            GUI.numberArea.append("=");
        }
    }
}
