#include<vector>
#include<map>
using namespace std;

int arithmeticTriplets(vector<int>& nums, int diff) {
    map<int, int> m;        
    for (int i = 0; i < nums.size(); i++) {
        m[nums[i]] = 1;
    }
    int res = 0;
    for (int i = 0; i < nums.size(); i++) {
        if (m[nums[i] + diff] != 0 && m[nums[i] + diff * 2] != 0) {
            res++;
        }
    }
    return res;
}