package com.maximus.medium;

//oh,ugly
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(num > 0) {
            if (num >= 1000) {
                for (i = 0; i < num / 1000; i++) result.append('M');
                num = num - (num / 1000) * 1000;
            }
            else if(num >= 900 && num < 1000) {
                result.append("CM");
                num -= 900;
            }
            else if (num >= 500 && num < 900) {
                for (i = 0; i < num / 500; i++) result.append('D');
                num = num - (num / 500) * 500;
            }
            else if(num < 500 && num >= 400) {
                result.append("CD");
                num -= 400;
            }
            else if (num < 400 && num >= 100) {
                for (i = 0; i < num / 100; i++) result.append('C');
                num = num - num / 100 * 100;
            }
            else if(num >= 90 && num < 100) {
                result.append("XC");
                num -= 90;
            }
            else if (num < 90 && num >= 50) {
                for(i = 0;i < num / 50;i++) result.append('L');
                num = num - num / 50 * 50;
            }
            else if(num >= 40 && num < 50) {
                result.append("XL");
                num -= 40;
            }
            else if(num < 40 && num >= 10) {
                for(i = 0;i < num / 10;i++) result.append('X');
                num = num - num / 10 * 10;
            }
            else if(num == 9) {
                result.append("IX");
                num -= 9;
            }
            else if(num < 9 && num >= 5) {
                result.append('V');
                num -= 5;
            }
            else if(num == 4) {
                result.append("IV");
                num = 0;
            }
            else if(num < 4) {
                for(i = 0;i < num;i++)
                    result.append('I');
                num = 0;
            }
        }
        return result.toString();
    }
}
