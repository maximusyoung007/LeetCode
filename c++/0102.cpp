#include "tree.h"
#include <vector>
#include <queue>
using namespace std;

class Solution0102 {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<vector<int>> result;
        if(root == nullptr) {
            return result;
        }
        else {
            q.push(root);
        }
        while(!q.empty()) {
            int tempSize = q.size();
            vector<int> partResult;
            while(tempSize > 0) {
                TreeNode* temp = q.front();
                q.pop();
                if(temp != nullptr) {
                    partResult.push_back(temp->val);
                }
                if(temp != nullptr && temp->left != nullptr) {
                    q.push(temp->left);
                }
                if(temp != nullptr && temp->right != nullptr) {
                    q.push(temp->right);
                }
                tempSize--;
                if(tempSize == 0) {
                    result.push_back(partResult);
                }
            }
        }
        return result;
    }
};