#include"0007.h"
#include<string>
#include<limits.h>
using namespace std;
int Solution0007::reverse(int x) {
    if(x == 0) return 0;
    string str = "";
    long x_ = 0;
    if(x < 0) {
        str += "-";
        x_ = x;
        x_ = -x_;
    } else {
        x_ = x;
    }
    while(x_ != 0) {
        str += x_ % 10 + '0';
        x_ /= 10;
    }
    long l = stol(str);
    if(l < INT_MIN || l > INT_MAX) {
        return 0;
    }
    int result = (int)l;
    return result;
}