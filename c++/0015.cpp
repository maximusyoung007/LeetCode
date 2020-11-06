#include<vector>
#include<algorithm>
#include "0015.h"
using namespace std;

vector<vector<int>> Solution0015::threeSum(vector<int> &nums) {
    if(nums.size() < 3)
        return {};
    sort(nums.begin(),nums.end());
    vector<vector<int>> result;
    for(int i = 0;i < nums.size();i++) {
        //如果nums[i]>0，sum必定>0，
        if(nums[i] > 0) {
            break;
        }
        //避免出现重复解
        if(i > 0 && nums[i] == nums[i-1])
            continue;
        int left = i + 1;
        int right = nums.size() - 1;
        while(left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0) {
                int a[3] = {nums[i],nums[left],nums[right]};
                vector<int> b(a,a+3);
                result.push_back(b);
                //避免出现重复解
                while (left < right && nums[left] == nums[left+1]) left++;
                while (left < right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            }
            if(sum > 0) right--;
            if(sum < 0) left++;
        }
    }
    return result;
}