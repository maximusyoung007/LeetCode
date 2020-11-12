#include"listnode.h"
#include"0445.h"
#include<stack>
using namespace std;
//头插法，建立一个虚拟的head节点，往这个节点后面插入节点
ListNode* Solution0445 ::addTwoNumbers(ListNode *l1, ListNode *l2) {
    ListNode *tail,*head = new ListNode(0, nullptr);
    stack<int> stack1;
    stack<int> stack2;
    while(l1) {
        stack1.push(l1->val);
        l1 = l1->next;
    }
    while(l2) {
        stack2.push(l2->val);
        l2 = l2->next;
    }
    int a,b,sum,carry = 0;
    while(!stack1.empty() || !stack2.empty()) {
        a = !stack1.empty() ? stack1.top() : 0;
        b = !stack2.empty() ? stack2.top() : 0;
        sum = (a + b + carry) % 10;
        tail = new ListNode(sum);
        tail->next = head->next;
        head->next = tail;
        carry = (a + b + carry) / 10;
        if(!stack1.empty()) {
            stack1.pop();
        }
        if(!stack2.empty()) {
            stack2.pop();
        }
    }
    if(carry > 0) {
        tail = new ListNode(carry);
        tail->next = head->next;
        head->next = tail;
    }
    return head->next;
}