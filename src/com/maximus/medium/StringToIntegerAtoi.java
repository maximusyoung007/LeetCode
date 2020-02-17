package com.maximus.medium;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        //flag标记是正数还是负数,numShow标记数字是否出现过
        boolean flag = true,numShow = false;
        int result = 0,num = 0,count = 0;
        if(str.contains("0-") || str.contains("0+"))
            return 0;
        else if(str.equals("-") || str.equals("+"))
            return 0;
        else {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ' ' && count > 0 && !numShow)return 0;
                if (c == ' ' && !numShow) continue;
                else if (c == '-' && count == 0) {
                    flag = false;
                    count++;
                } else if (c == '+' && count == 0) {
                    flag = true;
                    count++;
                } else if (c >= '0' && c <= '9') {
                    numShow = true;
                    num = c - '0';
                    if(flag) {
                        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                            result = Integer.MAX_VALUE;
                            break;
                        }
                        result = result * 10 + num;
                    }
                    else if(!flag) {
                        if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                            result = Integer.MIN_VALUE;
                            break;
                        }
                        //System.out.println(result);
                        result = result * 10 - num;
                    }
                } else {
                    //最先开始出现的是其他字符,返回0
                    if (result == 0)
                        return 0;
                    //否则遇到其他字符时跳出循环
                    else
                        break;
                }
            }
        }
        return result;
    }
}
