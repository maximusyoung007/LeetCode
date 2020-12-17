#include "0066.h"

vector<int> Solution0066::plusOne(vector<int> &digits) {
    reverse(digits.begin(),digits.end());

    int carry = 0;
    for(int i = 0;i < digits.size();i++) {
        if(i == 0) {
            digits[i] = digits[i] + 1 + carry;
        } else {
            digits[i] = digits[i] + carry;
        }
        if(digits[i] >= 10) {
            digits[i] = digits[i] % 10;
            carry = 1;
        } else {
            carry = 0;
        }
    }
    if(carry == 1) {
        digits.push_back(1);
    }
    reverse(digits.begin(),digits.end());
    return digits;
}