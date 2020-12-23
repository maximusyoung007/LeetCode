#include <string>
using namespace std;

class Solution0091 {
public:
    int numDecodings(string s) {
        if(s[0] == '0') return 0;
        int a0 = 1,a1 = 1;
        for(int i = 1;i < s.size();i++) {
            int temp = a1;
            if(s[i] == '0') {
                if(s[i-1] == '1' || s[i-1] == '2') {
                    a1 = a0;
                } else {
                    return 0;
                }
            } else {
                if(s[i-1] == '1' || (s[i-1] == '2' && s[i] >= '1' && s[i] <= '6')) {
                    a1 = a0 + a1;
                }
            }
            a0 = temp;
        }
        return a1;
    }
};