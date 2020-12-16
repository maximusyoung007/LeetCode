#include "0061.h"

ListNode* Solution0061::rotateRight(ListNode *head, int k) {
    if(head == nullptr) {
        return nullptr;
    }
    ListNode *p = head;
    int n = 1;
    while(p->next != nullptr) {
        n++;
        p = p->next;
    }
    if(n == k) {
        return head;
    }
    if(k > n) {
        k = k % n;
    }
    p->next = head;
    int breakPoint = n - k > 0 ? n - k : k - n;
    ListNode *q = head;
    for(int i = 0;i < breakPoint - 1;i++) {
        q = q->next;
    }
    ListNode* newHead = q->next;
    q->next = nullptr;
    return newHead;
}