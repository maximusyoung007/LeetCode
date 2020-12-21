#include "listnode.h"

class Solution0082 {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode *pre = new ListNode(0);
        pre->next = head;
        ListNode *p1 = pre;
        ListNode *p2 = head;

        while(p2 != nullptr && p2->next != nullptr) {
            if(p1->next->val != p2->next->val) {
                p1 = p1->next;
                p2 = p2->next;
            } else {
                while(p2 != nullptr && p2->next != nullptr && p2->next->val == p1->next->val) {
                    p2 = p2->next;
                }
                p1->next = p2->next;
                p2 = p2->next;
            }
        }
        return pre->next;
    }
};

