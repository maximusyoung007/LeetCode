#include"listnode.h"

class Solution0092 {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if(m == 1) {
            ListNode* result = reverseN(head,n);
            return result;
        }
        head->next = reverseBetween(head->next,m-1,n-1);
        return head;
    }

    ListNode* successor;
    ListNode* reverseN(ListNode* head,int n) {
        if(n == 1) {
            successor = head->next;
            return head;
        }

        ListNode* last = reverseN(head->next,n-1);
        head->next->next = head;
        head->next = successor;
        return last;
    }
};