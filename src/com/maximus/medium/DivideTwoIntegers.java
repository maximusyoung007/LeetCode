package com.maximus.medium;
//参考：https://leetcode-cn.com/problems/divide-two-integers/solution/po-su-de-xiang-fa-mei-you-wei-yun-suan-mei-you-yi-/
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)(dividend)),b = Math.abs((long)(divisor));
        long res = div(a,b);
        if((dividend ^ divisor) < 0) res = -res;
        if(res >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(res <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)res;
    }
    public long div(long a,long b) {
        if(a == b)
            return 1;
        if(a < b)
            return 0;
        long temp = b,res = 1;
        while(b + b < a) {
            b += b;
            res += res;
        }
        res += div(a - b,temp);
        return res;
    }
}
