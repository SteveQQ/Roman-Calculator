package com.steveqq.tests;

import com.steveqq.gui.ButtonClicker;
import com.steveqq.gui.GUI;

import javax.swing.*;
import java.util.Map;

/**
 * Created by SteveQ on 2016-08-25.
 */
public class ButtonClickerTester {
    public static void main(String[] args){
        GUI gui = new GUI();
        ButtonClicker buttonClicker = new ButtonClicker(gui);
        for(Map.Entry entry : buttonClicker.buttonMap.entrySet()){
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
