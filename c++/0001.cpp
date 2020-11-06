#include<algorithm>
#include<vector>
#include<map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums,int target) {
        map<int,int> nums_map;
        for(int i = 0; i < nums.size(); i++) {
            if(nums_map.count(target - nums[i]) == 1) {
                vector<int> result;
                result.push_back(i);
                result.push_back(nums_map[target-nums[i]]);
                sort(result.begin(),result.end());
                return result;
            }
            nums_map.insert(pair<int,int>(nums[i],i));
        }
        return {};
    }

};

