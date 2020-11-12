#include<string>
#include<algorithm>
#include<stdlib.h>
#include"0415.h"
using namespace std;

string Solution0415::addStrings(string num1, string num2) {
    reverse(num1.begin(),num1.end());
    reverse(num2.begin(),num2.end());
    int i = 0,carry = 0;
    string result = "";
    while(i < num1.size() || i < num2.size()) {
        int a = i < num1.size() ? num1[i] - '0' : 0;
        int b = i < num2.size() ? num2[i] - '0' : 0;
        int sum = a + b + carry;
        int temp = sum % 10;
        carry = sum / 10;
        result += to_string(temp);
        i++;
    }
    if(carry > 0) {
        result += to_string(carry);
    }
    reverse(result.begin(),result.end());
    return result;
}