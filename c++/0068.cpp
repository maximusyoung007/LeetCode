#include<string>
#include<vector>
using namespace std;

class Solution0068 {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<vector<string>> t;
        vector<string> tt;
        vector<string> result;
        int i = 0, lenTT = 0;
        while(i < words.size()) {
            tt.push_back(words[i]);
            //默认每个单词自带一个空格
            lenTT += words[i].length() + 1;
            i++;
            //字母长度大于maxWidth，就把最后一个退出来，
            if(lenTT - 1 > maxWidth) {
                tt.pop_back();
                t.push_back(tt);
                i--;
                //重新初始化
                lenTT = 0;
                tt.clear();
            }
        }
        if(tt.size() != 0) {
            t.push_back(tt);
        }

        for(int i = 0; i < t.size(); i++) {
            vector<string> temp = t[i];
            if(i == t.size() - 1) {
                string r = "";
                for(int j = 0; j < temp.size(); j++) {
                    if(j != temp.size() - 1) {
                        r += temp[j] + " ";
                    } else {
                        r += temp[j];
                        if(maxWidth > r.size()) {
                            int minus = maxWidth - r.size();
                            for(int k = 0; k < minus; k++) {
                                r += " ";
                            }
                        }
                    }
                }
                result.push_back(r);
            }
            else {
                int len = 0;
                int size = temp.size();
                for (string s : temp) {
                    len += s.size();
                }
                int blank = 0, rest = 0;
                if(size != 1) {
                    blank = (maxWidth - len) / (size - 1);
                    rest = (maxWidth - len) % (size - 1);
                } else {
                    blank = (maxWidth - len) / size;
                }
                string blank2 = "";
                for(int j = 0; j < blank; j++) {
                    blank2 += " ";
                }
                string r = "";
                for(int j = 0; j < temp.size(); j++) {
                    if(j != temp.size() - 1) {
                        r += temp[j] + blank2;
                        if(rest > 0) {
                            r += " ";
                            rest--;
                        }
                    }
                    else {
                        r += temp[j];
                    }
                }
                if(maxWidth > r.size()) {
                    int minus = maxWidth - r.size();
                    for(int k = 0; k < minus; k++) {
                        r += " ";
                    }
                }
                result.push_back(r);
            }
        }
        return result;
    }
};