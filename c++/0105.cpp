#include<vector>
#include<map>
#include"tree.h"
using namespace std;

class Solution0105 {
public:
    map<int, int> rightOrder;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int n  = inorder.size();
        for (int i = 0; i < n; i++) {
            rightOrder[inorder[i]] = i;
        }

        return rec(preorder, inorder, 0, n-1, 0, n-1);
    }

    TreeNode* rec(vector<int>& preorder, vector<int>& inorder, int preL, int preR, int inL, int inR) {
        if(preL > preR) {
            return nullptr;
        }
        TreeNode* root = new TreeNode(preorder[preL]);
        int i = rightOrder[preorder[preL]];
        int size = i - inL;
        root->left = rec(preorder, inorder, preL + 1, preL + size, inL, i - 1);
        root->right = rec(preorder, inorder, preL + size + 1, preR, i + 1, inR);
        return root;
    }
};