#include "tree.h"
#include <limits.h>
#include <algorithm>
using namespace std;

class Solution0111 {
public:
    int minDepth(TreeNode* root) {
        int minD = INT_MAX;
        if(root == nullptr) {
            return 0;
        }
        else if (root->left == nullptr && root->right == nullptr) {
            return 1;
        }
        else {
            if(root->left != nullptr) {
                minD = min(minDepth(root->left), minD);
            }
            if(root->right != nullptr) {
                minD = min(minDepth(root->right), minD);
            }
        }
        return minD + 1;
    }
};