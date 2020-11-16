#include"0016.h"
#include "limits.h"
#include<math.h>
#include<algorithm>
using namespace std;

int Solution0016 ::threeSumClosest(vector<int> &nums, int target) {
    if(nums.size() < 3)
        return 0;
    sort(nums.begin(),nums.end());
    int minimum = INT_MAX,result = 0;
    for(int i = 0;i < nums.size();i++) {
        int left = i + 1,right = nums.size() - 1;
        while(left < right) {
            int sum = nums[left] + nums[right] + nums[i];
            if(sum == target) {
                return target;
            }
            else if(sum > target) {
                right--;
                if(abs(sum - target) < abs(minimum)) {
                    minimum = sum - target;
                    result = sum;
                }
            }
            else if(sum < target) {
                left++;
                if(abs(sum - target) < abs(minimum)) {
                    minimum = sum - target;
                    result = sum;
                }
            }
        }
    }
    return result;
}