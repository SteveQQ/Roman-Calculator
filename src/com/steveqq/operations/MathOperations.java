package com.steveqq.operations;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class MathOperations {
    private ArrayList<Integer> elementsToCount = new ArrayList<>();
    private ArrayList<Character> operationSymbols = new ArrayList<>();

    //-----GETTERS & SETTERS-----//
    public ArrayList<Integer> getElementsToCount() {
        return elementsToCount;
    }

    public void addElementsToCount(Integer element) {
        this.elementsToCount.add(element);
    }

    public ArrayList<Character> getOperationSymbols() {
        return operationSymbols;
    }

    public void addOperationSymbols(Character operationSymbol) {
        this.operationSymbols.add(operationSymbol);
    }
    //-----GETTERS & SETTERS-----//

    public void clearOperationData(){
        elementsToCount.clear();
        operationSymbols.clear();
    }

    public Integer doMath() throws IllegalArgumentException{
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
