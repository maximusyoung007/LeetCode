#include"tree.h"
#include<string>
#include<vector>
using namespace std;

class Solution0129 {
public:
    int sumNumbers(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int sum = 0;
        return dfs(root, sum);
    }

    int dfs(TreeNode* root, int sum) {
       if (root == nullptr) {
           return 0;
       }
       int result = sum * 10 + root->val;
       if (root->left == nullptr && root->right == nullptr) {
           return result;
       } else {
           return dfs(root->left, result) + dfs(root->right, result);
       }
    }
};