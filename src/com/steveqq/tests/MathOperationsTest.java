package com.steveqq.tests;

import com.steveqq.operations.MathOperations;

import java.util.ArrayList;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class MathOperationsTest {
    public static void main(String[] args){
        MathOperations math = new MathOperations();
        ArrayList<Integer> testIntArrList = new ArrayList<Integer>();
        ArrayList<Character> testSymArrList = new ArrayList<Character>();
        testIntArrList.add(4);
        testIntArrList.add(2);
        testIntArrList.add(3);
        testSymArrList.add('+');
        testSymArrList.add('-');
        System.out.println(math.doMath(testIntArrList, testSymArrList));

    }
}
