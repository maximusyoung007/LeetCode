#include<vector>
#include <map>
#include <algorithm>
using namespace std;

class Solution0954 {
public:
    bool canReorderDoubled(vector<int>& A) {
        map<int,int> m;
        sort(A.begin(),A.end());
        for(int i = 0;i < A.size();i++) {
            if(m.count(A[i]) == 0) {
                m[A[i]] = 1;
            } else {
                m[A[i]] += 1;
            }
        }
        for(map<int,int>::iterator iter = m.begin(); iter != m.end(); iter++) {
            while (iter->second > 0) {
                if (iter->first < 0) {
                    if (iter->first % 2 != 0) return false;
                    else {
                        m[iter->first / 2] -= 1;
                        if (m[iter->first / 2] < 0) return false;
                    }
                }
                if (iter->first > 0) {
                    m[iter->first * 2] -= 1;
                    if (m[iter->first * 2] < 0) return false;
                }
                iter->second -= 1;
            }
        }
        return true;
    }
};