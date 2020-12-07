#include<vector>
using namespace std;
class Solution39 {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target);

    void dfs(vector<int> &candidate, int target, vector<int> &path, vector<vector<int>> &resultList);
};