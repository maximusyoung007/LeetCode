#include "tree.h"
#include<vector>
using namespace std;

class Solution0099 {
public:
    void recoverTree(TreeNode *tree) {
        vector<int> nums;
        midOrder(tree, nums);
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                y = nums[i + 1];
                if (x == -1) {
                    x = nums[i];
                } else {
                    break;
                }
            }
        }
        changeXY(tree, x, y);
    }

    void changeXY(TreeNode* tree, int x, int y) {
        if(tree == nullptr) {
            return;
        }
        if(tree->val == x || tree->val == y) {
            tree->val = tree->val == x ? y : x;
        }
        changeXY(tree->left, x, y);
        changeXY(tree->right, x, y);
    }

    void midOrder(TreeNode *tree, vector<int>& nums) {
        if (tree == nullptr) {
            return;
        }
        midOrder(tree->left, nums);
        nums.push_back(tree->val);
        midOrder(tree->right, nums);
    }
};