#include <vector>
using namespace std;

class Solution0077 {
public:
    vector<vector<int>> combine(int n, int k);

    void bfs(vector<vector<int>> &v,int level,int k,int n,vector<int> &partResult);
};