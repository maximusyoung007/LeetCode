#include<vector>
#include<map>
#include"tree.h"
using namespace std;

class Solution0106 {
public:
    map<int, int> inOrderMap;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n = inorder.size();
        for (int i = 0; i < n; i++) {
            inOrderMap[inorder[i]] = i;
        }
        return cur(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    TreeNode* cur(vector<int>& inorder, vector<int>& postOrder, int inL, int inR, int postL, int postR) {
        if(postL > postR) {
            return nullptr;
        }
        TreeNode* tree = new TreeNode(postOrder[postR]);
        int i = inOrderMap[postOrder[postR]];
        int size = inR - i;
        tree->left = cur(inorder, postOrder, inL, i - 1, postL, postR - 1 - size);
        tree->right = cur(inorder, postOrder, i + 1, inR, postR - size, postR - 1);
        return tree;
    }
};