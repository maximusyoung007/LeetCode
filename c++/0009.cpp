#include"0009.h"
using namespace std;

bool Solution0009::isPalindrome(int x) {
    if(x < 0) return false;
    long x_ = 0,temp = (int)x;
    while(x > 0) {
        x_ = x_ * 10 + x % 10;
        x /= 10;
    }
    if(temp == x_) return true;
    else return false;
}