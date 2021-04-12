#include<vector>
using namespace std;

class Solution0154 {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 0) {
            return -1;
        }
        if(nums.size() == 1) {
            return nums[0];
        }
        if(nums[0] < nums[nums.size() - 1]) {
            return nums[0];
        }
        int left = 0, right = nums.size() - 1;
        while(left < right) {
            int mid = (left + right) / 2;;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                right -= 1;
            }
        }
        return nums[left];
    }
};