package com.maximus.medium;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int time = 0;
        StringBuilder result = new StringBuilder();
        for(int i = num2.length() - 1;i >= 0;i--) {
            char c = num2.charAt(i);
            StringBuilder a = multiply(num1,c);
            for(int j = 0;j < time;j++) {
                a.append("0");
            }
            time++;
            result = add(a,result);
        }
        return result.toString();
    }
    public StringBuilder add(StringBuilder num1,StringBuilder num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int c = a + b + carry;
            carry = c / 10;
            c = c % 10;
            result.insert(0,c);
            i--;
            j--;
        }
        if(carry == 1)
            result.insert(0,1);
        return result;
    }
    public StringBuilder multiply(String num1,char c) {
        int a = c - '0';
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i = num1.length() - 1;i >= 0;i--) {
            int b = num1.charAt(i) - '0';
            int temp = b * a + carry;
            carry = temp / 10;
            b = temp % 10;
            result.insert(0,b);
        }
        if(carry > 0)
            result.insert(0,carry);
        return result;
    }
}
