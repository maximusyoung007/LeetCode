#include "0050.h"
double Solution0050::myPow(double x, int n) {
    long N = n;
    return N >= 0 ? cal(x,N) : 1.0 / cal(x,(-N));
}

double Solution0050::cal(double x, long n) {
    if(n == 0) {
        return 1.0;
    }
    double y = cal(x,n / 2);
    return n % 2 == 0 ? y * y : y * y * x;
}