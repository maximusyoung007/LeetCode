#include<string>
using namespace std;

int findTheLongestBalancedSubstring(string s) {
    if (s.find("1") == string::npos || s.find("0") == string::npos) {
        return 0;
    }
    int countZero = 0;
    int countOne = 0;
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '0') {
            countZero++;
        } else {
            if (countZero != 0) {
                countOne++;
            }
            if (countZero >= countOne) {
                if (countZero == countOne) {
                    if (countZero > res) {
                        res = countZero;
                    }
                    countOne = 0;
                    countZero = 0;
                } else if (countZero > countOne) {
                    if (countOne > res) {
                        res = countOne;
                    }
                    if (i == s.length()-1 || s[i+1] == '0') {
                        countZero = 0;
                        countOne = 0;
                    }
                }
            } 
        }
    }
    return res * 2;
}