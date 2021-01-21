#include<vector>
using namespace std;

class Solution0041 {
public:
    int firstMissingPositive(vector<int>& nums) {
        if(nums.size() == 0) {
            return 1;
        }
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            while(nums[i] <= n && nums[i] >= 1) {
                int x = nums[i];
                if(x != nums[x - 1]) {
                    int t = x;
                    nums[i] = nums[x - 1];
                    nums[x - 1] = t;
                }else {
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] != i+1) {
                return i + 1;
            }
        }
        return n + 1;
    }
};