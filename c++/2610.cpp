#include<vector>
#include<map>
using namespace std;

vector<vector<int> > findMatrix(vector<int>& nums) {
    map<int, int> m;
    for (int i = 0; i < nums.size(); i++) {
        m[nums[i]]++;
    }
    vector<vector<int> > res;
    while (true) {
        vector<int> t;
        int countZero = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second != 0) {
                t.push_back(it->first);
                m[it->first]--;
            } else {
                countZero++;
            }
        }
        if (!t.empty()) {
            res.push_back(t);
        }
        if (countZero == m.size()) {
            break;
        }
    }
    return res;
}