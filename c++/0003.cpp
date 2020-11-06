#include<string>
#include<set>
#include "0003.h"
using namespace std;

int Solution0003::lengthOfLongestsubString(string s) {
    set<int> set;
    int len = 0,right = 0;
    for (int i = 0; i < s.size(); i++) {
        if (i != 0) {
            set.erase(s[i - 1]);
        }
        while (right < s.size() && !set.count(s[right])) {
            set.insert(s[right]);
            right++;
        }
        if (right - i > len) {
            len = right - i;
        }
    }
    return len;
}