#include <set>
#include"0217.h"
bool Solution0217::containsDuplicate(vector<int> &nums) {
    set<int> s;
    for(int i = 0;i < nums.size();i++) {
        s.insert(nums[i]);
    }
    if(s.size() == nums.size()) {
        return false;
    }
    return true;
}