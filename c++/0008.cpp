#include<string>
#include<limits.h>
#include"0008.h"
using namespace std;
int Solution0008::myAtoi(string s) {
    s.erase(0,s.find_first_not_of(" "));
    s.erase(s.find_last_not_of(" ") + 1);
    int flag = 1;
    long result_ = 0;
    if((s[0] > '9' || s[0] < '0') && s[0] != '-' && s[0] != '+') return 0;
    int i;
    if(s[0] == '-') {
        i = 1;
        flag = -1;
    } else if(s[0] == '+') {
        i = 1;
        flag = 1;
    } else {
        i = 0;
        flag = 1;
    }
    for(i;i < s.size();i++) {
        if(s[i] >= '0' && s[i] <= '9') {
            result_ = result_ * 10 + (s[i] - '0') * flag;
        } else {
            break;
        }
        if(result_ > INT_MAX) {
            return INT_MAX;
        } else if(result_ < INT_MIN) {
            return INT_MIN;
        }
    }
    return (int)result_;
}