#include "0022.h"
using namespace std;

vector<string> Solution0022::generateParenthesis(int n) {
    vector<string> result;
    if(n == 0) {
        return result;
    }
    string littleResult = "";
    dfs(littleResult,0,0,result,n);
    return result;
}

void Solution0022 :: dfs(const string &littleResult,int left,int right,vector<string> &result,int n) {
    if(left == n && right == n) {
        result.push_back(littleResult);
    }
    if(left < right) {
        return;
    }
    if(left < n) {
        dfs(littleResult + "(",left + 1,right,result,n);
    }
    if(right < n) {
        dfs(littleResult + ")",left,right + 1,result, n);
    }
}