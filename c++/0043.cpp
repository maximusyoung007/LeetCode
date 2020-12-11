#include "0043.h"
#include <algorithm>
string Solution::multiply(string num1, string num2) {
    if(num1 == "0" || num2 == "0") {
        return "0";
    }
    reverse(num2.begin(),num2.end());
    string result = "";
    for(int i = 0;i < num2.size();i++) {
        string result1 = multiplyToOne(num1,num2[i]);
        for(int j = 0;j < i;j++) {
            result1 += "0";
        }
        result = add(result,result1);
    }
    return result;
}

string Solution::multiplyToOne(string num1, char num2) {
    string result = "";
    int a = num2 - '0';
    reverse(num1.begin(),num1.end());
    int carry = 0;
    for(int i = 0;i < num1.size();i++) {
        int b = num1[i] - '0';
        int temp = a * b + carry;
        if(temp >= 10) {
            carry = temp / 10;
            temp = temp % 10;
        } else {
            carry = 0;
        }
        result += to_string(temp);
    }
    if(carry > 0) {
        result += to_string(carry);
    }
    reverse(result.begin(),result.end());
    return result;
}

string Solution::add(string num1, string num2) {
    reverse(num1.begin(), num1.end());
    reverse(num2.begin(), num2.end());
    int k = 0,carry = 0;
    string result;
    while(num1.size() > k || num2.size() > k) {
        int a = num1.size() > k ? num1[k] - '0' : 0;
        int b = num2.size() > k ? num2[k] - '0' : 0;
        int temp = a + b + carry;
        if(temp >= 10) {
            temp = temp % 10;
            carry = 1;
        } else {
            carry = 0;
        }
        result += to_string(temp);
        k++;
    }
    if(carry > 0) {
        result += to_string(carry);
    }
    reverse(result.begin(),result.end());
    return result;
}