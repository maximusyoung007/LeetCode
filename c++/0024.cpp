#include "0024.h"
using namespace std;

ListNode* Solution0024 ::swapPairs(ListNode *head) {
    ListNode *preHead = new ListNode(-1);
    preHead->next = head;
    ListNode *temp = preHead;
    while(temp->next && temp->next->next) {
        ListNode *node1 = temp->next;
        ListNode *node2 = temp->next->next;
        temp->next = node2;
        node1->next = node2->next;
        node2->next = node1;
        temp = temp->next->next;
    }
    return preHead->next;
}