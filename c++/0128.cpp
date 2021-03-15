#include<vector>
#include<set>
using namespace std;

class Solution0128 {
public:
    int longestConsecutive(vector<int>& nums) {
        set<int> s;
        for (int i = 0; i < nums.size(); i++) {
            s.insert(nums[i]);
        }
        int max = 0;
        for (int num : nums) {
            int count = 0, num2 = 0;
            if (s.count(num - 1) == 0) {
                count++;
                num2 = num;
                while(s.count(num2 + 1) != 0) {
                    count++;
                    num2++;
                }
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }
};