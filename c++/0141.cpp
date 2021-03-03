#include"listnode.h"
#include<set>
using namespace std;

class Solution0141 {
public:
    bool hasCycle(ListNode *head) {
        set<ListNode*> s;
        while(head != nullptr) {
            if (s.count(head) == 1) {
                return true;
            } else {
                s.insert(head);
            }
            head = head->next;
        }
        return false;
    }
};