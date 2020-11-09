#include<vector>
#include<algorithm>
#include "0018.h"
using namespace std;

vector<vector<int>> Solution0018::fourSum(vector<int> &nums, int target) {
    if(nums.size() < 4) {
        return {};
    }
    vector<vector<int>> result;
    int len = nums.size();
    //-2,-1,0,0,1,2
    sort(nums.begin(),nums.end());
    for(int i = 0;i < len - 3;i++) {
        //去重
        if(i > 0 && nums[i] == nums[i-1]) {
            continue;
        }
        if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
            break;
        }
        if(nums[i] + nums[len-1] + nums[len-2] + nums[len-3] < target) {
            continue;
        }
        for(int j = i + 1;j < len - 2;j++) {
            if(j > i + 1 && nums[j] == nums[j-1]) {
                continue;
            }
            if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                break;
            }
            if(nums[i] + nums[j] + nums[len-1] + nums[len-2] < target) {
                continue;
            }
            int left = j+1,right = len - 1;
            while(left < right) {
                if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                    int a[4] = {nums[i], nums[j], nums[left], nums[right]};
                    vector<int> temp(a, a + 4);
                    result.push_back(temp);
                    while (left < right && nums[left] == nums[left + 1]) ++left;
                        left++;
                    while (left < right && nums[right] == nums[right - 1]) --right;
                        right--;
                }
                else if(nums[i] + nums[j] + nums[left] + nums[right] < target)left++;
                else if(nums[i] + nums[j] + nums[left] + nums[right] > target)right--;
            }
        }
    }
    return result;
}