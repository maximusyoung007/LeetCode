#include"0014.h"
using namespace std;
string Solution0014 ::longestCommonPrefix(vector<string>& strs) {
    if(!strs.size()) return "";
    string s1 = strs[0];
    for(int i = 1;i < strs.size();i++) {
        string s2 = strs[i];
        int j = 0;
        string tem = "";
        while(s1[j] == s2[j] && j < s1.size()) {
            tem += s1[j];
            j++;
        }
        s1 = tem;
    }
    return s1;
}