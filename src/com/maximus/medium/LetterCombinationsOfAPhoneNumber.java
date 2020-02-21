package com.maximus.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.equals(""))
            return result;
        Map<String,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqs");
        map.put("8","tuv");
        map.put("9","wxyz");
        comb(digits,0,sb,map,result);
        return result;
    }
    public void comb(String digits,int i,StringBuilder sb,Map<String,String> map,List<String> result) {
        //两者长度相等，说明集齐了相应位数
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            sb = new StringBuilder();
            return;
        }
        String digit = String.valueOf(digits.charAt(i));
        String letters = map.get(digit);
        for(int j = 0;j < letters.length();j++) {
            sb.append(letters.charAt(j));
            comb(digits,i + 1,sb,map,result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
