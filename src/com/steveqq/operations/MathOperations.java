package com.steveqq.operations;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by SteveQ on 2016-08-17.
 */
public final class MathOperations {
    public static ArrayList<Integer> elementsToCount = new ArrayList<Integer>();;
    public static ArrayList<Character> operationSymbols = new ArrayList<Character>();;

    public static void clearOperationData(){
        elementsToCount.clear();
        operationSymbols.clear();
    }

    public static Integer doMath() throws IllegalArgumentException{
        Integer result = elementsToCount.get(0);
        for(int i=1; i < elementsToCount.size(); i++) {
            Character curOeration = operationSymbols.get(i-1);
            switch (curOeration) {
                case '+':
                    result = result + elementsToCount.get(i);
                    break;
                case '-':
                    result = result - elementsToCount.get(i);
                    break;
                case '*':
                    result = result * elementsToCount.get(i);
                    break;
                case '/':
                    if(result < elementsToCount.get(i)){
                        throw new IllegalArgumentException();
                    } else {
                        result = result / elementsToCount.get(i);
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}
