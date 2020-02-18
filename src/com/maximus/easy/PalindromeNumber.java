package com.maximus.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int x2 = 0,xTemp = x;
        while(xTemp > 0) {
            x2 = x2 * 10 + xTemp % 10;
            xTemp = xTemp/ 10;
        }
        if(x != x2)
            return false;
        return true;
    }
}
