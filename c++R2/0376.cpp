#include<vector>
using namespace std;

int wiggleMaxLength(vector<int>& nums) {
    int n = nums.size();

    //两个dp，一个记录差为正数的最长序列，一个记录差为负数的最长序列
    vector<int> dp1(n, 0);
    vector<int> dp2(n, 0);

    dp1[0] = 1;
    dp2[0] = 1;

    int res = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            //如果这一轮的差是正数，那么上一轮就是负数，反之同理
            if (nums[i] - nums[j] > 0) {
                dp1[i] = max(dp1[i], dp2[j] + 1);
            } else if (nums[i] - nums[j] < 0) {
                dp2[i] = max(dp2[i], dp1[j] + 1);
            } else {
                dp1[i] = 0;
                dp2[i] = 0;
            }
        }

        res = max(res, max(dp1[i], dp2[i]));
    }

    return res;
}