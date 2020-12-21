#include"listnode.h"

class Solution0086 {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode *head1 = new ListNode(-1);
        ListNode *p1 = head1;
        ListNode *head2 = new ListNode(-1);
        ListNode *p2 = head2;

        while(head != nullptr) {
            if(head->val < x) {
                ListNode *new1 = new ListNode(head->val);
                p1->next = new1;
                p1 = p1->next;
            } else {
                ListNode *new2 = new ListNode(head->val);
                p2->next = new2;
                p2 = p2->next;
            }
            head = head->next;
        }
        p1->next = head2->next;
        p2->next = nullptr;
        return head1->next;
    }
};