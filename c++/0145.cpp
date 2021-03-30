#include"tree.h"
#include<vector>
using namespace std;

class Solution0145 {
public:
    vector<int> result;
    vector<int> postorderTraversal(TreeNode* root) {
        afterOrder(root);
        return result;
    }

    void afterOrder(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        afterOrder(root->left);
        afterOrder(root->right);
        result.push_back(root->val);
    }
};