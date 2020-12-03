#include<vector>
using namespace std;
#ifndef C___0047_H
#define C___0047_H
#endif //C___0047_H
class Solution0047 {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums);
    void bfs(vector<int>& curr,vector<int>& used,vector<int>& nums,vector<vector<int>>& result);
};
