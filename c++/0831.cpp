#include<string>
using namespace std;

string maskPII(string s) {
    string res = "";
    string sNum = "";
    if (s.find("@") == string::npos) {
        int countNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] <= '9' && s[i] >= '0') {
                sNum = sNum + s[i];
                countNum++;
            }
        }
        if (countNum == 10) {
            return res.append("***-***-").append(sNum.substr(sNum.length() - 4, 4));
        } else if (countNum == 11) {
            return res.append("+*-***-***-").append(sNum.substr(sNum.length() - 4, 4));
        } else if (countNum == 12) {
            return res.append("+**-***-***-").append(sNum.substr(sNum.length() - 4, 4));
        } else {
            return res.append("+***-***-***-").append(sNum.substr(sNum.length() - 4, 4));
        }
    } else {
        bool before = true;
        for (int i = 0; i < s.length(); i++) {
            if (before) {
                if (i == 0) {
                    res.append(string(1, tolower(s[i])));
                    res.append("*****");
                } else if (s[i+1] == '@'){
                    res.append(string(1, tolower(s[i])));   
                }
            }
            if (s[i] == '@') {
                before = false;
                res.append("@");
                continue;
            }
            if (!before) {
                if (s[i] != '.') {
                    res.append(string(1, tolower(s[i])));
                } else {
                    res.append(".");
                }
            }
        }
    }
    return res;
}