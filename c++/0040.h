#include<vector>
using namespace std;
class Solution40 {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target);

    void dfs(vector<int> &candidate, int target, vector<int> &path, vector<vector<int>> &resultList,int begin);
};