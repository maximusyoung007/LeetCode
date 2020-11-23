#include"0020.h"
using namespace std;

bool Solution0020::isValid(string s) {
    map<char,char> myMap{{']','['},{'}','{'},{')','('}};
    stack<char> myStack;

    for(int i = 0;i < s.size();i++) {
        if(!myMap.count(s[i])) {
            myStack.push(s[i]);
        } else {
            if(myStack.empty() || myStack.top() != myMap[s[i]]) {
                return false;
            } else {
                myStack.pop();
            }
        }
    }
    return myStack.empty();
}