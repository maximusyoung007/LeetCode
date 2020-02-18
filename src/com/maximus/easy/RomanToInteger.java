package com.maximus.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        for(int i = 0;i < s.length() - 1;i++) {
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        result += map.get(s.charAt(s.length() - 1));
        return result;
    }
}
