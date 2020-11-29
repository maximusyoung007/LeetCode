#include "0038.h"
using namespace std;
string Solution0038 :: countAndSay(int n) {
    if(n == 1) return "1";
    string s = countAndSay(n - 1);
    int count = 1;
    string result = "";
    for(int i = 0;i < s.size() - 1;i++) {
        if(s[i] == s[i+1]){
            count++;
        } else {
            result += count + '0';
            result += s[i];
            count = 1;
        }
    }
    if(s[s.size() - 1] != s[s.size() - 2]) {
        result = result + "1" + s[s.size() - 1];
    } else {
        result += count + '0';
        result += s[s.size() - 1];
    }
    return result;
}