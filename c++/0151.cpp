#include<string>
#include<algorithm>
using namespace std;

class Solution0151 {
public:
    string reverseWords(string s) {
        s.erase(0,s.find_first_not_of(" "));
        s.erase(s.find_last_not_of(" ") + 1);
        int wordBegin = 0;
        int len = s.size();
        for (int i = 0; i < len; i++) {
            if (s[i] != ' ' && i != s.size() - 1) {
                continue;
            } else {
                int left = wordBegin, right;
                if (i != s.size() - 1) {
                    right = i - 1;
                } else {
                    right = i;
                }
                while (left <= right) {
                    char t;
                    t = s[left];
                    s[left] = s[right];
                    s[right] = t;
                    left++;
                    right--;
                }
                while (s[i+1] == ' ') {
                    s.erase(s.begin() + i);
                }
                wordBegin = i + 1;
            }
        }
        reverse(s.begin(), s.end());
        return s;
    }

};