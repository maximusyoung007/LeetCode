#include "listnode.h"

class Solution0025 {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* hair = new ListNode(-1);
        hair->next = head;
        ListNode* start = head;
        ListNode* end = head;
        while(end->next != nullptr) {
            for(int i = 0;i < k - 1;i++) {
                if(end->next != nullptr) {
                    end = end->next;
                }else {
                    break;
                }
            }
            ListNode *pre = hair;
            //翻转从start到end
            ListNode* e = reverseStartEnd(start,end->next);
            pre->next = e;
            pre = hair;
            for(int i = 0;i < k;i++) {
                pre = pre->next;
            }
        }
        return hair;
    }

    ListNode* reverseStartEnd(ListNode* start,ListNode* end) {
        ListNode *cur = nullptr,*pre = start;
        while(pre != end) {
            ListNode* temp = pre->next;
            pre->next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

};