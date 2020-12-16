#include "0058.h"
#include <algorithm>

int Solution0058::lengthOfLastWord(string s) {
    if(s.size() == 0) {
        return 0;
    }
    int len = 0;
    s.erase(s.find_last_not_of(" ") + 1);
    reverse(s.begin(),s.end());
    for(int i = 0;i < s.size();i++) {
        if(s[i] != ' ') {
            len++;
        } else {
            break;
        }
    }
    return len;
}