#include<string>
#include<vector>
#include<algorithm>
using namespace std;

class Solution0060 {
public:
    string getPermutation(int n, int k) {
        k -= 1;
        string result;
        vector<int> v;
        for(int i = 1; i <= n; i++) {
            v.push_back(i);
        }
        for(int i = n - 1; i >= 0; i--) {
            int quotient = k / calFal(i);
            result += (v[quotient] + '0');
            v.erase(begin(v) + quotient);
            k = k % calFal(i);
        }
        return result;
    }

    int calFal(int n) {
        if(n == 0) {
            return 1;
        }
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
};