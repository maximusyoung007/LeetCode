package com.maximus.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses  {
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        String s1 = "";
        List<String> subR1 = new ArrayList<>();
        subR1.add(s1);
        String s2 = "()";
        List<String> subR2 = new ArrayList<>();
        subR2.add(s2);
        result.add(subR1);
        result.add(subR2);
        for(int i = 2;i <= n;i++) {
            List<String> str3 = new ArrayList<>();
            for(int j = 0;j < i;j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for(String s : str1) {
                    for(String ss : str2) {
                        String rs = "(" + s + ")" + ss;
                        str3.add(rs);
                    }
                }
            }
            result.add(str3);
        }
        return result.get(result.size() - 1);
    }
}
