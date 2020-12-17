#include "0071.h"
#include<stack>
#include<vector>

string Solution0071::simplifyPath(string path) {
    vector<string> v;
    string s = "";
    stack<string> stack;
    for(int i = 0;i < path.size();i++) {
        if(path[i] != '/') {
            s += path[i];
        } else if(path[i] == '/' && s.size() > 0) {
            v.push_back(s);
            s = "";
        }
    }
    if(s.size() > 0) {
        v.push_back(s);
    }
    for(int i = 0; i < v.size();i++) {
        if(v[i] == "..") {
            if(stack.size() > 0) {
                stack.pop();
            }
        } else if(v[i] == "." || v[i] == " ") {
            continue;
        } else {
            stack.push(v[i]);
        }
    }
    string result;
    int len = stack.size();
    for(int i = 0;i < len;i++) {
        string partResult = "/" + stack.top();
        stack.pop();
        result = partResult + result;
    }
    if(result.size() == 0) {
        return "/";
    }
    return result;
}