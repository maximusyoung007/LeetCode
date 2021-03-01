#include"tree.h"
#include<vector>
using namespace std;

class Solution0108 {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return rec(nums, 0, nums.size() - 1);
    }

    TreeNode* rec(vector<int>&nums, int begin, int end) {
        if (begin > end) {
            return nullptr;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode* tree = new TreeNode(nums[mid]);
        tree->left = rec(nums, begin, mid - 1);
        tree->right = rec(nums, mid + 1, end);
        return tree;
    }
};