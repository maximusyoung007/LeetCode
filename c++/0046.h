#ifndef C___0046_H
#define C___0046_H
#include<vector>
using namespace std;
class Solution0046 {
public:
    vector<vector<int>> permute(vector<int>& nums);
    void bfs(vector<int>& curr,vector<int>& used,vector<int>& nums,vector<vector<int>>& result);
};
#endif //C___0046_H
