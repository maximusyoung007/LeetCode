#include"0005.h"
#include<string>
using namespace std;
string Solution0005::longestPalindrome(string s) {
    string result = "";
    int left1 = 0,right1 = 0,left2 = 0,right2 = 0;
    for(int i = 0;i < s.size();i++) {
        left1 = right1 = i;
        left2 = i;
        right2 = i + 1;
        while(left1 >= 0 && right1 < s.size()) {
            if(s[left1] == s[right1]) {
                if(right1 - left1 + 1 > result.size()) {
                    result = s.substr(left1,right1 - left1 + 1);
                }
                left1--;
                right1++;
            } else {
                break;
            }
        }
        while(left2 >= 0 && right2 < s.size()) {
            if(s[left2] == s[right2]) {
                if(right2 - left2 + 1 > result.size()) {
                    result = s.substr(left2,right2 - left2 + 1);
                }
                left2--;
                right2++;
            } else {
                break;
            }
        }
    }
    return result;
}