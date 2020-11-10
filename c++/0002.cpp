#include"0002.h"
using namespace std;

ListNode* Solution0002 ::addTwoNumbers(ListNode *l1, ListNode *l2) {
    ListNode *head = nullptr,*tail = nullptr;
    int carry = 0;
    while(l1 || l2) {
        int n1,n2;
        if(l1 != nullptr) {
            n1 = l1->val;
        } else {
            n1 = 0;
        }
        if(l2 != nullptr) {
            n2 = l2->val;
        } else {
            n2 = 0;
        }
        int tem = n1 + n2 + carry;
        if(head == nullptr) {
            head = tail = new ListNode(tem % 10);
        } else {
            tail->next = new ListNode(tem % 10);
            tail = tail->next;
        }
        carry = tem / 10;
        if(l1 != nullptr) {
            l1 = l1->next;
        }
        if(l2 != nullptr) {
            l2 = l2->next;
        }
    }
    if(carry > 0) {
        tail->next = new ListNode(carry);
    }
    return head;
}