#include<vector>
using namespace std;

class Solution0152 {
public:
    int maxProduct(vector<int>& nums) {
        vector<int> maxNums(nums), minNums(nums);
        int r = maxNums[0];
        for (int i = 1; i < nums.size(); i++) {
            maxNums[i] = max(max(maxNums[i - 1] * nums[i], minNums[i - 1] * nums[i]), nums[i]);
            minNums[i] = min(min(minNums[i - 1] * nums[i], maxNums[i - 1] * nums[i]), nums[i]);
            if (maxNums[i] > r) {
                r = maxNums[i];
            }
        }
        return r;
    }
};