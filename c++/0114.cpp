#include"tree.h"
#include<vector>
using namespace std;

class Solution0114 {
public:
    void flatten(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        vector<int> r;
        preOrder(root, r);
        root->left = nullptr;
        TreeNode* temp = root;
        for (int i = 1; i < r.size(); i++) {
            TreeNode* t = new TreeNode(r[i]);
            temp->right = t;
            temp = t;
        }
    }

    void preOrder(TreeNode* root, vector<int>& r) {
         if (root == nullptr) {
             return;
         }
         r.push_back(root->val);
         preOrder(root->left, r);
         preOrder(root->right, r);
    }
};