#include<vector>
#include<string>
#include<map>
using namespace std;

class Solution0140 {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();
        vector<string> tm{""};
        map<int, vector<string>> m;
        for (int i = 0; i <= n; i++) {
            m[i] = tm;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                string s1 = s.substr(i, j - i);
                if (count(wordDict.begin(), wordDict.end(), s1) != 0) {
                    vector<string> pr = m[j];
                    vector<string> t = m[i];
                    for (int k = 0; k < t.size(); k++) {
                        string st = t[k];
                        if (i != 0 && st == "") {
                            continue;
                        }
                        string tps = st + " " + s1;
                        pr.push_back(tps);
                    }
                    m[j] = pr;
                }
            }
        }
        vector<string> result;
        for (string string1 : m[n]) {
            if (string1 != "") {
                string1 = string1.substr(1, string1.size() - 1);
                result.push_back(string1);
            }
        }
        return result;
    }
};