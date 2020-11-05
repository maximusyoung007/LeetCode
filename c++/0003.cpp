#include<string>
#include "0003.h"
using namespace std;

int Solution0003::lengthOfLongestsubString(string s) {
    //abcabcbb
    int len = 0;
    int j = 1;
    for(int i = 0;i < s.length();i++) {
        int temp_len = j - i;
        while(j < s.length() && s[j] != s[i]) {
            j++;
            temp_len++;
            if(s[j] == s[j + 1] && j+1 <= s.length() - 2) {
                i = j+1;
                j = i+1;
            }
        }
        if(temp_len > len) {
            len = temp_len;
        }
    }
    return len;
}