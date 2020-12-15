#include<vector>
using namespace std;

class Solution0055 {
public:
    bool canJump(vector<int>& nums);

    void bfs(vector<int> &nums,int index,vector<int> &result,vector<int> &visited);
};