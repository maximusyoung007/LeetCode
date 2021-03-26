#include"listnode.h"

class Solution0143 {
public:
    void reorderList(ListNode* head) {
        if (head == nullptr) {
            return;
        }
        ListNode *fast = head;
        ListNode *slow = head;
        while(fast->next != nullptr && fast->next->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        ListNode* head2 = slow->next;
        slow->next = nullptr;
        ListNode* pre = nullptr;
        while(head2 != nullptr) {
            ListNode* t = head2->next;
            head2->next = pre;
            pre = head2;
            head2 = t;
        }
        ListNode* l1 = head;
        ListNode* l2 = pre;
        ListNode* next;
        while (l1 != nullptr && l2 != nullptr) {
            next = l1->next;
            l1->next = l2;
            l2 = l2->next;
            l1->next->next = next;
            l1 = next;
        }
    }
};