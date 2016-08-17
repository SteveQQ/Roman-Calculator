package com.steveqq.tests;

import com.steveqq.parse.RomanParser;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class RomanParserTester {
    public static void main(String[] args){
        RomanParser romanParser = new RomanParser();
        char[] testCharArr = new char[]{'X', 'I', 'X'};
        ArrayList<Character> testCharArrList = romanParser.createCharArrayList(testCharArr);
        if (testCharArrList instanceof ArrayList){
            System.out.println(romanParser.createCharArrayList(testCharArr));
            System.out.println("PASSED");
        }

        ArrayList<Integer> testIntArrList = romanParser.mapRomanToDecimal(testCharArrList);
        if (testIntArrList instanceof ArrayList){
            System.out.println(testIntArrList);
            System.out.println("PASSED");
        }

        Integer result = romanParser.romanToDecimal("MCCCXXXVIII");
        System.out.println(result);

    }
}
