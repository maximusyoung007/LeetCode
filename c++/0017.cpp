#include"0017.h"
#include <queue>
#include <algorithm>
using namespace std;

vector<string> Solution0017 ::letterCombinations(string digits) {
    vector<string> result;
    queue<string> myQueue;
    vector<string> digitsStr{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    vector<string> digitsStr2;
    for(int i = 0;i < digits.size();i++) {
        int index = (digits[i] - '0') - 2;
        digitsStr2.push_back(digitsStr[index]);
    }
    for(int i = 0;i < digitsStr2.size();i++) {
        string s = digitsStr2[i];
        if(myQueue.empty()) {
            for(int j = 0;j < s.size();j++) {
                myQueue.push(s.substr(j,1));
            }
        } else if(!myQueue.empty()) {
            int len = myQueue.size();
            for(int j = 0;j < len;j++) {
                string tem = myQueue.front();
                myQueue.pop();
                for (int k = 0; k < s.size(); k++) {
                    string in = tem + s.substr(k,1);
                    myQueue.push(in);
                }
            }
        }
    }
    while(!myQueue.empty()) {
        string str = myQueue.front();
        result.push_back(str);
        myQueue.pop();
    }
    return result;
}