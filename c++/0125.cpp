#include<string>
using namespace std;
class Solution0125 {
public:
    bool isPalindrome(string s) {
        string s1 = "";
        for(int i = 0; i < s.size(); i++) {
            if(s[i] >= '0' && s[i] <= '9') {
                s1 += s[i];
            }
            if(s[i] >= 'a' && s[i] <= 'z') {
                s1 += s[i];
            }
            if(s[i] >= 'A' && s[i] <= 'Z') {
                s[i] = s[i] + 32;
                s1 += s[i];
            }
        }
        string s2 = s1;
        reverse(s1.begin(),s1.end());
        if(s1 == s2) {
            return true;
        }
        return false;
    }
};