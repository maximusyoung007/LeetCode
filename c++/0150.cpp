#include<vector>
#include<stack>
#include<string>
using namespace std;

class Solution0150 {
public:
    int evalRPN(vector<string>& tokens) {
        int k = 0;
        stack<int> s;
        while (k < tokens.size()) {
            string ts = tokens[k];
            if (ts != "+" && ts != "-" && ts != "*" && ts != "/") {
                int ti = stoi(ts);
                s.push(ti);
            }
            else {
                int ta = s.top();
                s.pop();
                int tb = s.top();
                s.pop();
                int tr;
                if (ts == "+") {
                    tr = ta + tb;
                    s.push(tr);
                } else if (ts == "-") {
                    tr = tb - ta;
                    s.push(tr);
                } else if (ts == "*") {
                    tr = tb * ta;
                    s.push(tr);
                } else if (ts == "/") {
                    tr = tb / ta;
                    s.push(tr);
                }
            }
            k++;
        }
        int result = s.top();
        return result;
    }
};