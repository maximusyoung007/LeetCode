#include <vector>
using namespace std;

class Solution0078 {
public:
    vector<vector<int>> subsets(vector<int>& nums);

    void bfs(vector<vector<int>> &v,int level,int k,int n,vector<int> &partResult,vector<int> &nums);

};