package com.steveqq.parse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class RomanParser {
    private Map<Character, Integer> romanValues;
    public RomanParser(){
        romanValues = new HashMap<Character, Integer>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
    }

    public ArrayList<Character> createCharArrayList(char[] charArray){
        ArrayList<Character> result = new ArrayList<Character>();
        for(Character character : charArray) {
            result.add(character);
        }
        return result;
    }

    public Map<Character, Integer> getRomanValues() {
        return romanValues;
    }

    public ArrayList<Integer> mapRomanToDecimal(ArrayList<Character> charArrList){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(Character character : charArrList){
            result.add(getRomanValues().get(character));
        }
        return result;
    }

    public Integer romanToDecimal(String romanNumber){
        char[] romanCharNumber = romanNumber.toCharArray();
        ArrayList<Character> romanCharArrayList = createCharArrayList(romanCharNumber);
        ArrayList<Integer> romanIntArrayList = mapRomanToDecimal(romanCharArrayList);
        Integer lastNumberInIntArrayList = romanIntArrayList.size() - 1;
        Integer result = romanIntArrayList.get(lastNumberInIntArrayList);
        for(int i = lastNumberInIntArrayList; i >= 1; i--) {
            if (romanIntArrayList.get(i-1) == romanIntArrayList.get(i)){
                result = result + romanIntArrayList.get(i-1);
            } else if(result > romanIntArrayList.get(i-1)){
                result = result - romanIntArrayList.get(i-1);
            } else if(result < romanIntArrayList.get(i-1)){
                result = result + romanIntArrayList.get(i-1);
            }
        }
        return result;
    }
}
