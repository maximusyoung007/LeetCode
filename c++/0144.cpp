#include<vector>
#include"tree.h"
using namespace std;

class Solution0144 {
public:
    vector<int> result;
    vector<int> preorderTraversal(TreeNode* root) {
        preOrder(root);
        return result;
    }

    void preOrder(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        result.push_back(root->val);
        preOrder(root->left);
        preOrder(root->right);
    }
};