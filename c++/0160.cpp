#include"listnode.h"

class Solution0160 {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *n1 = headA;
        ListNode *n2 = headB;
        while (n1 != n2) {
            if (n1 != nullptr) {
                n1 = n1->next;
            } else {
                n1 = headB;
            }

            if (n2 != nullptr) {
                n2 = n2->next;
            } else {
                n2 = headA;
            }
        }
        return n1;
    }
};