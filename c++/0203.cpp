#include "0203.h"
ListNode* Solution0203 :: removeElements(ListNode *head, int val) {
    ListNode *first = new ListNode(-1);
    ListNode *pre = new ListNode(-1);
    ListNode *cur = head;
    first = pre;
    while(cur != nullptr) {
        if(cur->val != val) {
            int curVal = cur->val;
            ListNode *tem = new ListNode(curVal);
            pre->next = tem;
            pre = tem;;
        }
        cur = cur->next;
    }
    return first->next;
}