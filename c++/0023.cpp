#include"0023.h"

ListNode* Solution0023::mergeKLists(vector<ListNode *> &lists) {
    if(lists.size() <= 0) {
        return nullptr;
    }
    ListNode *result = lists[0];
    for(int i = 1;i < lists.size();i++) {
        ListNode *l = lists[i];
        result = mergeTwoList(result,l);
    }
    return result;
}

ListNode* Solution0023::mergeTwoList(ListNode *l1, ListNode *l2) {
    ListNode* head = new ListNode(0),*tail = head,*p = l1,*q = l2;
    while(p != nullptr && q != nullptr) {
        int a = p != nullptr ? p->val : 0;
        int b = q != nullptr ? q->val : 0;
        if(a <= b) {
            tail->next = p;
            p = p->next;
        } else {
            tail->next = q;
            q = q->next;
        }
        tail = tail->next;
    }
    if(p != nullptr) {
        tail->next = p;
    } else if(q != nullptr) {
        tail->next = q;
    }
    return head->next;
}