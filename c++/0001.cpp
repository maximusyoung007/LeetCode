#include<iostream>
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
int main() {
    Solution *solution = new Solution();
    int a[4] = {2,7,11,5};
    vector<int> b(a,a+7);
    vector<int> result = solution->twoSum(b,9);
    for(vector<int>::iterator it = result.begin();it != result.end();it++) {
        cout << (*it) << " ";
    }
    cout << endl;
    int a1[3] = {3,3,4};
    vector<int> b1(a1,a1+3);
    vector<int> result2 = solution->twoSum(b1,7);
    for(vector<int>:: iterator it = result.begin();it != result.end();it++) {
        cout << (*it) << " ";
    }
}
