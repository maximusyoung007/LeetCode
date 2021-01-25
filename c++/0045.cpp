#include<vector>
using namespace std;

class Solution0045 {
public:
    int jump(vector<int>& nums) {
        if(nums.empty() || nums.size() == 1) {
            return 0;
        }
        int i = 0, sum = 0, nextIndex = 0;
        while(i != nums.size() - 1) {
            int count, max = 0;
            for(count = 1; count <= nums[i]; count++) {
                int t = i + count;
                if(t >= nums.size()) {
                    i = nums.size() - 1;
                    sum += 1;
                    break;
                }
                else {
                    int canReach = t + nums[t];
                    if (canReach >= max) {
                        if(canReach < nums.size()) {
                            max = canReach;
                        } else {
                            max = nums.size() - 1;
                        }
                        nextIndex = t;
                    }
                    if (count == nums[i]) {
                        i = nextIndex;
                        sum++;
                        break;
                    }
                }
            }
        }
        return sum;
    }
};