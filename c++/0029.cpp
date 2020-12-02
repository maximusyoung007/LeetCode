#include "0029.h"
#include <climits>

int Solution0029::divide(int dividend, int divisor) {
    if(dividend == 0) return 0;
    if(dividend == INT_MIN && divisor == -1) return INT_MAX;
    if(dividend == INT_MIN && divisor == 1) return INT_MIN;
    int count = 0;
    int dividend_ = dividend < 0 ? dividend : -dividend;
    int divisor_ = divisor < 0 ? divisor : -divisor;
    while(dividend_ <= divisor_) {
        int temp = divisor_;
        int c = 1;
        while(dividend_ - temp <= temp) {
            temp = temp + temp;
            c = c + c;
        }
        dividend_ -= temp;
        count += c;
    }
    if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
        count = -count;
    }
    if(count > INT_MAX || count < INT_MIN) {
        return INT_MAX;
    }
    return count;
}