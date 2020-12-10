#include "0043.h"
#include <algorithm>
string Solution::multiply(string num1, string num2) {

}

string Solution::multiplyToOne(string num1, char num2) {
    string result = "";
    int a = num2 - '0';
    reverse(num1.begin(),num1.end());
    int carry = 0;
    for(int i = 0;i < num1.size();i++) {
        int b = num1[i] - '0';
        int temp = a * b + carry;
        if(temp > 10) {
            temp = temp % 10;
            carry = 1;
        } else {
            carry = 0;
        }
        result += temp;
    }
    reverse(result.begin(),result.end());
    return result;
}

string Solution::add(string num1, string num2) {

}