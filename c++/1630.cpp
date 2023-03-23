#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

bool isArithmetic(vector<int>& nums) {
    int sub = nums[1] - nums[0];
    for (int i = 2; i < nums.size(); i++) {
        if (nums[i] - nums[i-1] != sub) {
            return false;
        }
    }
    return true;
}

vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
    int m = l.size();
    vector<bool> res(m);
    for(int i = 0; i < m; i++) {
        vector<int> t(&nums[l[i]], &nums[r[i] + 1]);
        sort(t.begin(), t.end());
        res[i] = isArithmetic(t);
    }
    return res;
}