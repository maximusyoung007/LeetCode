#include <vector>
#include <string>
using namespace std;
#ifndef C___0022_H
#define C___0022_H
class Solution0022 {
public:
    vector<string> generateParenthesis(int n);
    void dfs(const string &littleResult,int left,int right,vector<string> &result,int n);
};
#endif //C___0022_H
