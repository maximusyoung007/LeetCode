#include "0021.h"
using namespace std;

ListNode* Solution0021 ::mergeTwoLists(ListNode *l1, ListNode *l2) {
    ListNode *preHead = new ListNode(-1);
    ListNode *temp = preHead;
    while(l1 && l2) {
        if(l1->val <= l2->val) {
            temp->next = l1;
            l1 = l1->next;
        } else if(l1->val > l2->val) {
            temp->next = l2;
            l2 = l2->next;
        }
        temp = temp->next;
    }
    if(l1) {
        temp->next = l1;
    }
    if(l2) {
        temp->next = l2;
    }
    return preHead->next;
}