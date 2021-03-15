#include"listnode.h"

class Solution0206 {
public:
    ListNode* reverseList(ListNode* head) {
        //迭代
//        ListNode* pre = nullptr;
//        ListNode* cur = head;
//        while (cur != nullptr) {
//            ListNode* next = cur->next;
//            cur->next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
        //递归
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* r = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return r;
    }
};