#include"listnode.h"
#include"tree.h"

class Solution0109 {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        int end = 0;
        ListNode* t = head;
        while (t != nullptr) {
            t = t->next;
            end++;
        }
        return rec(head, 0, end - 1);
    }

    TreeNode* rec(ListNode* head, int begin, int end) {
        if (begin > end) {
            return nullptr;
        }
        ListNode* temp = head;
        int mid = begin + (end - begin) / 2;
        int tm = mid;
        while (tm > 0) {
            temp = temp->next;
            tm--;
        }
        TreeNode* tree = new TreeNode(temp->val);
        tree->left = rec(head, begin, mid - 1);
        tree->right = rec(head, mid + 1, end);
        return tree;
    }
};