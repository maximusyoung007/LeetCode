#include"listnode.h"
using namespace std;

class Solution0148 {
public:
    ListNode* sortList(ListNode* head) {
        if (head == nullptr) {
            return head;
        }
        int len = 0;
        ListNode* t = head;
        while (t) {
            t = t->next;
            len++;
        }
        ListNode* pre = new ListNode(0);
        pre->next = head;

        for (int i = 1; i < len; i = i * 2) {
            ListNode *tempPre = pre;
            ListNode *current = pre->next;
            while (current != nullptr) {
                //子链1
                ListNode* head1 = current;
                for (int k = 1; k < i && current != nullptr && current->next != nullptr; k++) {
                    current = current->next;
                }
                //断开
                ListNode* head2 = current->next;
                current->next = nullptr;
                current = head2;

                //子链2
                for (int k = 1; k < i && current != nullptr && current->next != nullptr; k++) {
                    current = current->next;
                }

                ListNode* next = nullptr;
                if (current != nullptr) {
                    next = current->next;
                    current->next = nullptr;
                }

                //合并
                ListNode* partResult = merge(head1, head2);

                //链接到结果上
                tempPre->next = partResult;
                while(tempPre->next != nullptr) {
                    tempPre = tempPre->next;
                }
                //下一组子链表
                current = next;
            }
        }
        return pre->next;
    }

    ListNode* merge(ListNode* head1, ListNode* head2) {
        ListNode* result = new ListNode(0);
        ListNode* t = result;
        ListNode* t1 = head1;
        ListNode* t2 = head2;
        while (t1 != nullptr && t2 != nullptr) {
            if (t1->val <= t2->val) {
                t->next = t1;
                t1 = t1->next;
            } else {
                t->next = t2;
                t2 = t2->next;
            }
            t = t->next;
        }
        if (t1 != nullptr) {
            t->next = t1;
        }
        if (t2 != nullptr) {
            t->next = t2;
        }
        return result->next;
    }
};