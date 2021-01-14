#include "listnode.h"

class Solution0025 {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* hair = new ListNode(-1);
        hair->next = head;
        int flag = 0;
        ListNode* start = head;
        ListNode* end = head;
        ListNode *pre = hair;
        while(end != nullptr) {
            for(int i = 0;i < k - 1;i++) {
                if(end->next != nullptr) {
                    end = end->next;
                }else {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) {
                pre->next = start;
                break;
            }
            ListNode* tail = end->next;
            //翻转从start到end
            ListNode* e = reverseStartEnd(start,end->next);
            pre->next = e;
            pre = start;
            start = tail;
            end = tail;
        }
        return hair->next;
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