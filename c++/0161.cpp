/**
给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。

注意：

满足编辑距离等于 1 有三种可能的情形：

    往 s 中插入一个字符得到 t
    从 s 中删除一个字符得到 t
    在 s 中替换一个字符得到 t

示例 1：

输入: s = "ab", t = "acb"
输出: true
解释: 可以将 'c' 插入字符串 s 来得到 t。

示例 2:

输入: s = "cab", t = "ad"
输出: false
解释: 无法通过 1 步操作使 s 变为 t。

示例 3:

输入: s = "1203", t = "1213"
输出: true
解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/one-edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
#include<string>
using namespace std;
class Solution0161 {
public:
    bool isOneEditDistance(string s, string t) {
        if (s == t) {
            return false;
        }
        return deleteA(s, t) || deleteA(t, s) || change(s, t);
    }

    bool deleteA(string s, string t) {
        for (int i = 0; i < t.size(); i++) {
            string temp = del(t, i);
            if (temp == s) {
                return true;
            }
        }
        return false;
    }

    bool change(string s, string t) {
        if (s.size() == t.size()) {
            for (int i = 0; i < s.size(); i++) {
                //s删除一个得到temp
                string temp = del(s, i);
                string temp2 = del(t, i);
                if (temp == temp2) {
                    return true;
                }
            }
        }
        return false;
    }

    string del(string s, int i) {
        string temp;
        if (i == 0) {
            temp = s.substr(1);
        } else if (i == s.size() - 1) {
            temp = s.substr(0, s.size() - 1);
        } else {
            temp = s.substr(0, i) + s.substr(i + 1, s.size() - 1 - i);
        }
        return temp;
    }
};