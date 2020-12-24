#include <vector>
using namespace std;

class Solution0118 {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> result;
        if(numRows == 0) {
            return result;
        }
        vector<int> v1{1};
        vector<int> v2{1,1};
        result.push_back(v1);
        if(numRows == 1) {
            return result;
        }
        result.push_back(v2);
        if(numRows == 2) {
            return result;
        }
        if(numRows > 2) {
            vector<int> vi;
            vector<int> vPre = v2;
            for(int i = 2;i < numRows;i++) {
                vi.push_back(1);
                for(int i = 0,j = 1;j < vPre.size();i++,j++) {
                    vi.push_back(vPre[i] + vPre[j]);
                }
                vi.push_back(1);
                result.push_back(vi);
                vPre = vi;
                vi.clear();
            }
        }
        return result;
    }
};