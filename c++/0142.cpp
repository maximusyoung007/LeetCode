#include"listnode.h"

class Solution0142 {
public:
    ListNode* detectCycle(ListNode *head) {
        ListNode *fast = head, *slow = head;
        while (fast != nullptr) {
            if (fast->next == nullptr) {
                return nullptr;
            }
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) break;
        }
        ListNode *result = head;
        if (result == slow) {
            return result;
        } else {
            while (result != slow) {
                //fast可能和slow都是null
                if (result->next == nullptr || slow->next == nullptr) {
                    return nullptr;
                }
                result = result->next;
                slow = slow->next;
                if (result == slow) {
                    return result;
                }
            }
        }
        return nullptr;
    }
};