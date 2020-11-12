#include"0371.h"

int Solution0371::getSum(int a, int b) {
    while(b != 0) {
        int temp = a ^ b;
        b = ((unsigned int) a & b) << 1;
        a = temp;
    }
    return a;
}