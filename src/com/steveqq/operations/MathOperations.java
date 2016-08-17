package com.steveqq.operations;

import java.util.ArrayList;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class MathOperations {
    private ArrayList<Integer> elementsToCount;
    private ArrayList<Character> operationSymbols;

    public MathOperations(){
        elementsToCount = new ArrayList<Integer>();
        operationSymbols = new ArrayList<Character>();
    }

    public void addElementsToCount(Integer elementsToCount) {
        this.elementsToCount.add(elementsToCount);
    }

    public ArrayList<Integer> getElementsToCount() {
        return elementsToCount;
    }
    public void addOperationSymbols(Character operationSymbols) {
        this.operationSymbols.add(operationSymbols);
    }

    public ArrayList<Character> getOperationSymbols() {
        return operationSymbols;
    }

    public Integer doMath(ArrayList<Integer> elementsList, ArrayList<Character> operationList){
        Integer result = elementsList.get(0);
        for(int i=1; i < elementsList.size(); i++) {
            Character curOeration = operationList.get(i-1);
            switch (curOeration) {
                case '+':
                    result = result + elementsList.get(i);
                    break;
                case '-':
                    result = result - elementsList.get(i);
                    break;
                case '*':
                    result = result * elementsList.get(i);
                    break;
                case '/':
                    result = result / elementsList.get(i);
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}
