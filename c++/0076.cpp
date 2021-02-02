#include<string>
#include<vector>
#include<map>
using namespace std;

class Solution0076 {
public:
    string minWindow(string s, string t) {
        if(s == "" || t == "") return "";
        if(s.size() < t.size()) return "";
        if(s == t) return s;
        int left = 0, right = 0, minLeft = 0, minRight = 0;
        int min = s.size() + 1;
        map<char,int> m1;
        int count = t.size();
        for(int i = 0; i < t.size(); i++) {
            if(m1.count(t[i]) == 0) {
                m1[t[i]] = 1;
            }
            else if(m1.count(t[i]) > 0) {
                m1[t[i]] += 1;
            }
        }
        while(right < s.size()) {
            if (m1.count(s[right]) > 0) {
                if (m1[s[right]] > 0) {
                    m1[s[right]]--;
                    count--;
                } else if (m1[s[right]] <= 0) {
                    m1[s[right]]--;
                }
            }
            right++;
            //如果当前符合，开始动左下标
            while (count == 0) {
                if(right - left < min) {
                    minLeft = left;
                    minRight = right;
                    min = right - left;
                }
                if(m1.count(s[left]) > 0) {
                    if(m1[s[left]] < 0) {
                        m1[s[left]]++;
                    } else if(m1[s[left]] >= 0) {
                        m1[s[left]]++;
                        count++;
                    }
                }
                left++;
            }
        }
        string result = s.substr(minLeft, minRight - minLeft);
        return result;
    }
};