#include<string>
#include<stack>
using namespace std;

class Solution0032 {
public:
    int longestValidParentheses(string s) {
        stack<int> myStack;
        int len = 0,maxLen = 0;
        myStack.push(-1);
        //利用栈统计以')'结尾的最大长度
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == '(') {
                myStack.push(i);
            } else if(s[i] == ')') {
                myStack.pop();
                if(myStack.size() == 0) {
                    myStack.push(i);
                }else {
                    len = i - myStack.top();
                    if(len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }
};