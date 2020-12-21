#include "listnode.h"
using namespace std;

class Solution0083 {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode *p1 = head;
        ListNode *p2 = head->next;
        while(p1->next != nullptr && p2 != nullptr) {
            if(p2->val == p1->val) {
                while(p2 != nullptr && p2->val == p1->val) {
                    p2 = p2->next;
                }
                p1->next = p2;
            }
            else {
                p1 = p1->next;
                p2 = p2->next;
            }
        }
        return head;
    }
};