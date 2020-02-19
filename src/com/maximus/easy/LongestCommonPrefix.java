package com.maximus.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String result = strs[0];
        for(int i = 1;i < strs.length;i++) {
            if(result.equals(""))
                return "";
            else {
                result = compareTwo(result,strs[i]);
            }
        }
        return result;
    }
    public String compareTwo(String s1,String s2) {
        String result = "";
        int len = Math.min(s1.length(),s2.length());
        for(int i = 0;i < len;i++) {
            if(s1.charAt(i) != s2.charAt(i))
                break;
            else
                result += s1.charAt(i);
        }
        return result;
    }
}
