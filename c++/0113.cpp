#include"tree.h"
#include<vector>
using namespace std;

class Solution0113 {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> result;
        vector<int> partResult;
        if(root == nullptr) {
            return result;
        }
        dfs(root, targetSum, partResult, result);
        return result;
    }

    void dfs(TreeNode* root, int targetSum, vector<int>& partResult, vector<vector<int>>& result) {
        partResult.push_back(root->val);
        if(root->left == nullptr && root->right == nullptr) {
            if (root->val == targetSum) {
                result.push_back(partResult);
            }
            return;
        }
        if (root->left != nullptr) {
            dfs(root->left, targetSum - root->val, partResult, result);
            partResult.pop_back();
        }
        if (root->right != nullptr) {
            dfs(root->right, targetSum - root->val, partResult, result);
            partResult.pop_back();
        }
    }
};