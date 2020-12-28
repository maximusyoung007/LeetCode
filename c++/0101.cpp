#include "tree.h"
#include <queue>
using namespace std;

class Solution0101 {
public:
    bool isSymmetric(TreeNode* root) {
        if(root == nullptr || (root->left == nullptr && root->right == nullptr)) {
            return true;
        }
        queue<TreeNode*> q;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty()) {
            TreeNode* left = q.front();
            q.pop();
            TreeNode* right = q.front();
            q.pop();
            if((left == nullptr && right != nullptr) || (left != nullptr && right == nullptr)) {
                return false;
            }
            if(left != nullptr && right != nullptr) {
                if (left->val != right->val) {
                    return false;
                }
            }
            if(left != nullptr && right != nullptr) {
                q.push(left->left);
                q.push(right->right);
                q.push(left->right);
                q.push(right->left);
            }
        }
        return true;
    }
};