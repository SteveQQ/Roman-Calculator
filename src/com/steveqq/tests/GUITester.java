package com.steveqq.tests;

import com.steveqq.gui.GUI;

import javax.swing.*;
import java.util.Map;

/**
 * Created by SteveQ on 2016-08-24.
 */
public class GUITester {
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.createButtonMap();
        for(Map.Entry entry : gui.buttonMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
