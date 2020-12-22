#include <string>
using namespace std;

class Solution0091 {
public:
    int numDecodings(string s) {
        if(s == "0") return 0;
        if(s[0] == '0') {
            int index = 0;
            for(int i = 0;i < s.size();i++) {
                if(s[i] == '0') {
                    index++;
                } else {
                    break;
                }
            }
            s = s.substr(index,s.size() - index);
        }
        if(s.size() == 1) return 1;
        if(s == "") return 0;
        int a0 = 1,a1;
        for(int i = 1;i < s.size();i++) {
            int s1 = s[i-1] - '0',s2 = s[i] - '0';
            if(s2 == 0) {
                a1 = a0;
            } else if(s1 * 10 + s2 <= 26) {
                a1 = a0 + 1;
            } else {
                a1 = a0;
            }
            a0 = a1;
        }
        return a1;
    }
};