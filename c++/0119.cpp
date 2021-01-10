#include <vector>
using namespace std;

class Solution0119 {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> r;
        vector<int> v1{1};
        vector<int> v2{1,1};
        if(rowIndex == 0) {
            return v1;
        }
        if(rowIndex == 1) {
            return v2;
        }
        if(rowIndex >= 2) {
            vector<int> vi;
            vector<int> vPre = v2;
            for(int i = 2;i <= rowIndex;i++) {
                vi.push_back(1);
                for(int i = 0,j = 1;j < vPre.size();i++,j++) {
                    vi.push_back(vPre[i] + vPre[j]);
                }
                vi.push_back(1);
                r.clear();
                r = vi;
                vPre = vi;
                vi.clear();
            }
        }
        return r;
    }
};