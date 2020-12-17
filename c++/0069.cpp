#include "0069.h"

int Solution0069::mySqrt(int x) {
    int i = 0;
    for(i = 1;(long)i * i <= x;i++);
    return i - 1;
}