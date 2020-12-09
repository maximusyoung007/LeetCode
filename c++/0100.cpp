#include "0100.h"

bool Solution0100::isSameTree(TreeNode *p, TreeNode *q) {
    if(p == nullptr && q == nullptr) {
        return true;
    }
    else if(p != nullptr && q != nullptr && p->val == q->val) {
        return isSameTree(p->left,q->left) && isSameTree(p->right,q->right);
    }
    return false;
}
