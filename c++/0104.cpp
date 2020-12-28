#include "tree.h"
#include <queue>
using namespace std;

class Solution0104 {
public:
    int maxDepth(TreeNode* root) {
        queue<TreeNode*> q;
        if(root == nullptr) {
            return 0;
        }
        else {
            q.push(root);
        }
        int result = 0;
        while(!q.empty()) {
            int tempSize = q.size();
            while(tempSize > 0) {
                TreeNode* temp = q.front();
                q.pop();
                if(temp != nullptr && temp->left != nullptr) {
                    q.push(temp->left);
                }
                if(temp != nullptr && temp->right != nullptr) {
                    q.push(temp->right);
                }
                tempSize--;
                if(tempSize == 0) {
                    result++;
                }
            }
        }
        return result;
    }
};