#include"tree.h"
#include<algorithm>
using namespace std;

class Solution0110 {
public:
    bool isBalanced(TreeNode* root) {
        if (root == nullptr) {
            return true;
        }
        if (abs(treeHeight(root->left) - treeHeight(root->right)) <= 1 && isBalanced(root->left) && isBalanced(root->right)) {
            return true;
        } else {
            return false;
        }
    }

    int treeHeight(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        return max(treeHeight(root->left), treeHeight(root->right)) + 1;
    }
};