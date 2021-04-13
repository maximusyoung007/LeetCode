#include<vector>
#include<string>
using namespace std;

class Solution0164 {
public:
    /**
     * 基数排序
     * @param nums
     * @return
     */
    int maximumGap(vector<int>& nums) {
        if (nums.size() < 2) {
            return 0;
        }
        vector<vector<int>> radix(10);
        vector<string> stringNums;
        int maxSize = 0;
        for (int n : nums) {
            string ts = to_string(n);
            if (ts.size() > maxSize) {
                maxSize = ts.size();
            }
        }

        int len = nums.size();
        int order = 1;
        while (order < maxSize + 1) {
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                int t = order;
                while (t > 1 && num > 0) {
                    num /= 10;
                    t--;
                }
                if (num == 0) {
                    radix[0].push_back(nums[i]);
                } else {
                    int index = num % 10;
                    radix[index].push_back(nums[i]);
                }
            }
            nums.clear();
            for (int j = 0; j < radix.size(); j++) {
                vector<int> tv = radix[j];
                for (int ti :tv) {
                    nums.push_back(ti);
                }
            }
            for (int i = 0; i < radix.size(); i++) {
                radix[i].clear();
            }
            order++;
        }
        int result = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i+1] - nums[i] > result) {
                result = nums[i+1] - nums[i];
            }
        }
        return result;
    }
};