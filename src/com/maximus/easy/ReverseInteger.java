package com.maximus.easy;

public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = true;
        if(x > 0) flag = true;
        else {
            flag = false;
            x = -x;
        }
        int last = 0,result = 0;
        while(x > 0) {
            last = x % 10;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && last > Integer.MAX_VALUE % 10))
                return 0;
            result = result * 10 + last;
            x = x / 10;
        }
        if(flag == false) result = -result;
        return result;
    }
}
