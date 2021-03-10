#include<vector>
using namespace std;

class Solution0268 {
public:
    int missingNumber(vector<int>& nums) {
        int sum1 = 0;
        for (int num : nums) {
            sum1 += num;
        }
        int sum2 = nums.size() * (nums.size() + 1) / 2;
        return sum2 - sum1;
    }
};