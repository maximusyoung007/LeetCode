#include<string>
#include<vector>
#include"0006.h"
using namespace std;
string Solution0006::convert(string s, int numRows) {
    if(s.size() == 1) return s;
    if(numRows == 1) return s;
    int index = 0,flag = -1;
    int maxRow = (s.size() > numRows ? numRows : s.size()) - 1;
    vector<string> result_(maxRow+1);
    for(int i = 0;i < s.size();i++) {
        result_[index] += s[i];
        if(index == maxRow || index == 0) {
            flag *= -1;
        }
        index += flag;
    }
    string result = "";
    for(int i = 0;i < result_.size();i++) {
        result += result_[i];
    }
    return result;
}