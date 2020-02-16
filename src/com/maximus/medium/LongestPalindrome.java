package com.maximus.medium;
//manacher
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String s1 = "$",result = "";
        int index = 0,maxn = 0;
        for(int i = 0;i < s.length();i++) {
            s1 = s1 + "#" + s.charAt(i);
        }
        s1 += "#^";
        int[] p = new int[s1.length()];
        int center = 0,right = 0;
        for(int i = 1;i < s1.length() - 1;i++) {
            int j =  2 * center - i;
            if(i < right)
                p[i] = Math.min(right - i,p[j]);
            else
                p[i] = 0;
            while(s1.charAt(i - p[i] - 1) == s1.charAt(i + p[i] + 1)) {
                p[i]++;
            }
            while(i + p[i] > right) {
                right = i + p[i];
                center = i;
            }
        }
        for(int i = 1;i < p.length;i++) {
            if(p[i] > maxn) {
                maxn = p[i];
                index = i;
            }
        }
        for(int i = (index - maxn) / 2;i < (index - maxn) / 2 + maxn;i++) {
            result = result + s.charAt(i);
        }
        return result;
    }
}
