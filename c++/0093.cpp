#include <vector>
#include <string>
using namespace std;

class Solution0093 {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<vector<string>> result;
        vector<string> partResult;
        vector<string> finalResult;
        for (int i = 0; i < s.size(); i++) {
           if (s[i] >= '9' && s[i] <= '0') {
               return finalResult;
           }
        }
        dfs(s, 0, partResult, result);
        for (vector<string> r : result) {
            string rs;
            for (string s1 : r) {
                rs = rs + s1 + ".";
            }
            rs = rs.substr(0, rs.size() - 1);
            finalResult.push_back(rs);
        }
        return finalResult;
    }

    void dfs(string s, int begin, vector<string>& partResult, vector<vector<string>>& result) {
        if (partResult.size() == 4) {
            if (begin >= s.size()) {
                result.push_back(partResult);
                return;
            }
            return;
        }
        int i;
        for (i = 1; i <= 3; i++) {
            if (begin + i > s.size()) {
                return;
            }
            string s1 = s.substr(begin, i);
            if (isLegal(s1)) {
                partResult.push_back(s1);
                dfs(s, begin + i, partResult, result);
                partResult.pop_back();
            } else {
                return;
            }
        }
        if (i == 3) {
            return;
        }
    }

    bool isLegal(string s) {
        if (s.size() > 1 && s[0] == '0') {
            return false;
        }
        int num = 0;
        for (int i = 0; i < s.size(); i++) {
            num = num * 10 + (s[i] - '0');
        }
        if (num > 255 || num < 0) {
            return false;
        }
        return true;
    }
};