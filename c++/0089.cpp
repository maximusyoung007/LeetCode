#include <vector>
#include <math.h>
#include<string>
using namespace std;

class Solution0089 {
public:
    vector<int> grayCode(int n) {
        vector<int> result;
        vector<string> a0{"0"};
        vector<string> a1{"0","1"};
        vector<int> b1 = stringToInt(a1);
        if(n == 0) {
            vector<int> b0 = stringToInt(a0);
            return b0;
        }
        if(n == 1) {
            vector<int> b1 = stringToInt(a1);
            return b1;
        }
        if(n >= 2) {
            vector<string> a2;
            int k = 0;
            while(k <= n - 2) {
                for (int i = 0; i < a1.size(); i++) {
                    a2.push_back("0" + a1[i]);
                }
                for(int i = a1.size() - 1;i >= 0;i--) {
                    a2.push_back("1" + a1[i]);
                }
                if (a2.size() == pow(2.0, n)) {
                    vector<int> result = stringToInt(a2);
                    return result;
                } else {
                    a1.clear();
                    a1.assign(a2.begin(), a2.end());
                    a2.clear();
                }
            }
        }
        return result;
    }

    vector<int> stringToInt(vector<string> v) {
        vector<int> result;
        for(int i = 0;i < v.size();i++) {
            string temp = v[i];
            reverse(temp.begin(),temp.end());
            int itemp = 0;
            for(int j = 0;j < temp.size();j++) {
                itemp = itemp + pow(2.0,j) * (temp[j] - '0');
            }
            result.push_back(itemp);
        }
        return result;
    }
};