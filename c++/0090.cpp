#include <vector>
using namespace std;

class Solution0090 {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> partResult;
        result.push_back(partResult);
        for(int i = 0;i <= nums.size();i++) {
            partResult.clear();
            dfs(result, partResult, i, 0, nums);
        }
        return result;
    }

    void dfs(vector<vector<int>> &result,vector<int> &partResult,int n,int begin,vector<int> &nums) {
        if(partResult.size() == n) {
            int i;
            for(i = 0;i < result.size();i++) {
                if(equals(result[i],partResult) == 1) {
                    return;
                }
            }
            if(i == result.size()) {
                result.push_back(partResult);
            }
            return;
        }
        for(int i = begin;i < nums.size();i++) {
            partResult.push_back(nums[i]);
            if (begin < nums.size()) {
                dfs(result, partResult, n, i + 1, nums);
            }
            partResult.pop_back();
        }
    }

    bool equals(vector<int> a1,vector<int> a2) {
        sort(a1.begin(),a1.end());
        sort(a2.begin(),a2.end());
        if(a1 == a2) {
            return true;
        }
        return false;
    }
};