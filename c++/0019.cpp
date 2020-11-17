#include "0019.h"
using namespace std;

ListNode* Solution0019 ::removeNthFromEnd(ListNode *head, int n) {
    ListNode *l1 = head;
    ListNode *h = new ListNode(0,head);
    ListNode *l2 = h;
    while(n > 0) {
        l1 = l1->next;
        n--;
    }
    while(l1) {
        l1 = l1->next;
        l2 = l2->next;
    }
    l2->next = l2->next->next;
    return h->next;
}