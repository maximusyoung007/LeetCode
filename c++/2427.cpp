#include<algorithm>
using namespace std;

int commonFactors(int a, int b) {
    int t = min(a, b);
    int res = 0;
    for (int i = 1; i <= t; i++) {
        if (a % i == 0 && b % i == 0) {
            res += 1;
        }
    }        
    return res;
}