package com.maximus.medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s,int numRows) {
    	if (numRows == 1) return s;

        List<StringBuilder> a = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            a.add(new StringBuilder());
        
        int rows = 0,add = 1;
        for (int i = 0;i < s.length();i++) {
            a.get(rows).append(s.charAt(i));
            rows = rows + add;
            if(rows == numRows - 1) 
            	add = -1;
            else if(rows == 0)
            	add = 1;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0;i < Math.min(numRows, s.length());i++) {
        	result.append(a.get(i));
        }
        return result.toString();
    }
}
