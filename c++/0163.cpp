/**
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。

示例：

输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
输出: ["2", "4->49", "51->74", "76->99"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/missing-ranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
#include<vector>
#include<string>
using namespace std;

class Solution0163 {
public:
    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> result;
        long long l = lower, u = upper;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] - l == 1) {
                result.push_back(to_string(l));
            } else if (nums[i] - 1 - l > 0) {
                string t = to_string(l) + "->" + to_string(nums[i] - 1);
                result.push_back(t);
            }
            l = (long long )nums[i] + 1;
        }
        if (l == u) {
            result.push_back(to_string(l));
        } else if (l < u) {
            result.push_back(to_string(l) + "->" + to_string(u));
        }
        return result;
    }
};
