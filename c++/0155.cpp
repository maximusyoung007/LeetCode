#include<stack>
#include"limits.h"
using namespace std;

class MinStack {
    stack<int> s;
    stack<int> minS;
public:
    /** initialize your data structure here. */
    MinStack() {
        minS.push(INT_MAX);
    }

    void push(int val) {
        s.push(val);
        if (val > minS.top()) {
            minS.push(minS.top());
        } else {
            minS.push(val);
        }
    }

    void pop() {
        s.pop();
        minS.pop();
    }

    int top() {
        return s.top();
    }

    int getMin() {
        return minS.top();
    }
};