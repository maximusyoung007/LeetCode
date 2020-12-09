#include "0258.h"
using namespace std;
int Solution0258::addDigits(int num) {
    if(num == 0) {
        return 0;
    }
    if(num % 9 == 0) {
        return 9;
    }
    return num % 9;
}