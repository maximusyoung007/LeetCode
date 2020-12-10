#include "0219.h"
#include <map>
#include <cmath>
bool Solution0219::containsNearbyDuplicate(vector<int> &nums, int k) {
    map<int,int> m;
    for(int i = 0;i < nums.size();i++) {
        if(m.count(nums[i]) == 0) {
            m[nums[i]] = i;
        } else {
            int j = m[nums[i]];
            if(abs(i - j) <= k) {
                return true;
            }
            m[nums[i]] = i;
        }
    }
    return false;
}