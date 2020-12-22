#include "tree.h"
#include <vector>
using namespace std;

class Solution0094 {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        if(root == nullptr) {
            return result;
        }
        ldr(root,result);
        return result;
    }

    void ldr(TreeNode *root,vector<int> &result) {
        if(root->left != nullptr) ldr(root->left,result);
        if(root != nullptr) result.push_back(root->val);
        if(root->right != nullptr) ldr(root->right,result);
    }
};