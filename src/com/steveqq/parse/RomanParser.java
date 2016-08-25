package com.steveqq.parse;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by SteveQ on 2016-08-17.
 */
public class RomanParser {
    private Map<Character, Integer> romanValues;
    private Map<Integer, String> toRomanMap;
    public RomanParser(){
        romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        toRomanMap = new TreeMap<>(Collections.reverseOrder());
        toRomanMap.put(1000, "M");
        toRomanMap.put(900, "CM");
        toRomanMap.put(500, "D");
        toRomanMap.put(400, "CD");
        toRomanMap.put(100, "C");
        toRomanMap.put(90, "XC");
        toRomanMap.put(50, "L");
        toRomanMap.put(40, "XL");
        toRomanMap.put(10, "X");
        toRomanMap.put(9, "IX");
        toRomanMap.put(5, "V");
        toRomanMap.put(4, "IV");
        toRomanMap.put(1, "I");
    }

    private ArrayList<Character> createCharArrayList(String string){
        ArrayList<Character> result = new ArrayList<>();
        for(Character character : string.toCharArray()) {
            result.add(character);
        }
        return result;
    }

    public ArrayList<Integer> mapRomanToDecimal(ArrayList<Character> charArrList){
        ArrayList<Integer> result = new ArrayList<>();
        for(Character character : charArrList){
            result.add(romanValues.get(character));
        }
        return result;
    }

    public Integer romanToDecimal(String romanNumber){
        ArrayList<Character> romanCharArrayList = createCharArrayList(romanNumber);
        ArrayList<Integer> romanIntArrayList = mapRomanToDecimal(romanCharArrayList);

        Integer result = romanIntArrayList.get(romanIntArrayList.size() - 1);

        for(int i = romanIntArrayList.size() - 1; i >= 1; i--) {
            if (romanIntArrayList.get(i-1).equals(romanIntArrayList.get(i))){
                result = result + romanIntArrayList.get(i-1);
            } else if(result > romanIntArrayList.get(i-1)){
                result = result - romanIntArrayList.get(i-1);
            } else if(result < romanIntArrayList.get(i-1)){
                result = result + romanIntArrayList.get(i-1);
            }
        }
        return result;
    }

    public String decimalToRoman(Integer number){
        String result = "";
        Integer division;
        if(number == 0){
            return result;
        }
        if(number > 0) {
            for (Map.Entry entry : toRomanMap.entrySet()) {
                division = number / (Integer) entry.getKey();
                if (division >= 1) {
                    for (int i = 0; i < division; i++) {
                        result = toRomanMap.get(entry.getKey()) + result;
                    }
                    result = result + decimalToRoman(number % (Integer) entry.getKey());
                    break;
                }
            }
        }
        return result;
    }
}
