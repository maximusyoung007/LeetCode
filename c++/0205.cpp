#include "0205.h"

bool Solution0205::isIsomorphic(string s, string t) {
    map<char,char> m;
    for(int i = 0;i < s.size();i++) {
        char a = s[i];
        char b = t[i];
        if(m.count(a) == 0) {
            m[a] = b;
        } else {
            char c = m[a];
            if(c != b) {
                return false;
            }
        }
    }
    m.clear();
    for(int i = 0;i < s.size();i++) {
        char b = s[i];
        char a = t[i];
        if(m.count(a) == 0) {
            m[a] = b;
        } else {
            char c = m[a];
            if(c != b) {
                return false;
            }
        }
    }
    return true;
}