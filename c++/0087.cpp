#include<string>
#include<vector>
using namespace std;

class Solution0087 {
public:
    bool isScramble(string s1, string s2) {
        //如果s1长度不等于s2,返回false
        if (s1.length() != s2.length()) {
            return false;
        }
        //如果s1等于s2，返回true
        if (s1 == s2) {
            return true;
        }
        //如果两个字符串的字母出现不一致，返回false
        vector<char> v1;
        vector<char> v2;
        for (int i = 0; i < s1.size(); i++) {
            v1.push_back(s1[i]);
            v2.push_back(s2[i]);
        }
        sort(v1.begin(),v1.end());
        sort(v2.begin(),v2.end());
        for (int i = 0; i < v1.size(); i++) {
            if(v1[i] != v2[i]) {
                return false;
            }
        }
        //遍历每个位置，切割字符串，情况1，直接切割，情况2，切割并交换,判断s1是否能变成s2的相应部分
        //s1 == t1, s2 == t2;s1 == t2, s2 == t1
        for(int i = 1; i < s1.size(); i++) {
            if(isScramble(s1.substr(0, i), s2.substr(0, i)) && isScramble(s1.substr(i, s1.size() - i), s2.substr(i, s2.size() - 1))) {
                return true;
            }
            if(isScramble(s1.substr(0, i), s2.substr(s2.size() - i)) && isScramble(s1.substr(i, s1.size() - 1), s2.substr(0, s2.size() - i))) {
                return true;
            }
        }
        return false;
    }
};