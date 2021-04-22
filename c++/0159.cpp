/*
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。

示例 1:

输入: "eceba"
输出: 3
解释: t 是 "ece"，长度为3。

示例 2:

输入: "ccaabbb"
输出: 5
解释: t 是 "aabbb"，长度为5。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
#include<string>
#include<map>
using namespace std;
class Solution0159 {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        int len = s.size();
        if (len < 3) {
            return len;
        }
        int left = 0, right = 0;
        int result = 0, t = 0;
        map<char, int> m;
        while (right < len) {
            if (m.count(s[right]) == 0) {
                m[s[right]] = 1;
            } else {
                m[s[right]]++;
            }
            //如果包含大于两个char,先去除
            if (m.size() > 2) {
                while (m.size() > 2) {
                    if (m[s[left]] == 1) {
                        m.erase(s[left]);
                    } else {
                        m[s[left]]--;
                    }
                    left++;
                }
            }
            //统计出现的总次数
            else {
                map<char, int>::iterator iter;
                iter = m.begin();
                while (iter != m.end()) {
                    t += iter->second;
                    iter++;
                }
                if (t > result) {
                    result = t;
                }
                t = 0;
            }
            right++;
        }
        return result;
    }
};