package com.maximus.easy;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int len2 = haystack.length();
        for(int i = 0;i < len2 - len + 1;i++) {
            String temp = haystack.substring(i,i + len);
            if(temp.equals(needle))
                return i;
        }
        return -1;
    }
}
