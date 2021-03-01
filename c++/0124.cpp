#include<vector>
#include"tree.h"
#include<limits.h>
using namespace std;

class Solution0124 {
public:
    int maxPathSum(TreeNode* root, int &val) {
        if (root == nullptr) {
            return 0;
        }
        int left = max(0, maxPathSum(root->left, val));
        int right = max(0, maxPathSum(root->right, val));
        //左中右
        int lcr = left + root->val + right;
        //左中或者右中更大的那一个，是下一次递归路径中的一部分
        int r = max(left, right) + root->val;
        //最大值是左中右或者左中或者右中
        val = max(val, max(lcr, r));
        return r;
    }

    int maxPathSum(TreeNode* root) {
        int val = INT_MIN;
        maxPathSum(root, val);
        return val;
    }
};