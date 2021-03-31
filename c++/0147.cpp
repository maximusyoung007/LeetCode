#include"listnode.h"

class Solution0147 {
public:
    ListNode* insertionSortList(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }
        ListNode* pre = new ListNode(0);
        pre->next = head;
        ListNode* last = head;
        ListNode* current = head->next;
        while (current != nullptr) {
            if (current->val >= last->val) {
                last = last->next;
            } else {
                ListNode* t = pre->next, *p = pre;
                while(t != nullptr) {
                    if (current->val < t->val) {
                        last->next = current->next;
                        current->next = p->next;
                        p->next = current;
                        break;
                    }
                    t = t->next;
                    p = p->next;
                }
            }
            current = last->next;
        }
        return pre->next;
    }
};