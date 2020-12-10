#include "0204.h"
#include <vector>
using namespace std;
int Solution204::countPrimes(int n) {
    if(n == 0 || n == 1) {
        return 0;
    }
    int num = 0;
    vector<int> judge(n,0);
    for(int i = 2;i < n;i++) {
        if(judge[i] == 0) {
            num++;
            if((long)i * i < n) {
                for (int j = i * i; j < n; j += i) {
                    judge[j] = 1;
                }
            }
        }
    }
    return num;
}