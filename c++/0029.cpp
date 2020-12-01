#include "0029.h"
#include <climits>

int Solution0029::divide(int dividend, int divisor) {
    if(dividend == 0) return 0;
    if(divisor == 1) return 1;
    long count = 0;
    long dividend_ = (long)dividend > 0 ? (long)dividend : -(long)dividend;
    long divisor_ = (long)divisor > 0 ? (long)divisor : -(long)divisor;
    while(dividend_ >= divisor_) {
        int temp = 1;
        while(dividend_ - divisor_ >= divisor_) {
            divisor_ += divisor_;
            temp += temp;
        }
        dividend_ -= divisor_;

    }
    if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
        count = -count;
    }
    if(count > INT_MAX || count < INT_MIN) {
        return INT_MAX;
    }
    return count;
}