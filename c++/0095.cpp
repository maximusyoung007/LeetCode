#include"tree.h"
#include<vector>
using namespace std;

class Solution0095 {
public:
    vector<TreeNode*> generateTrees(int n) {
        vector<TreeNode*> treeNode;
        if (n == 0) {
            return treeNode;
        }
        vector<int> v;
        for (int i = 1; i <= n; i++) {
            v.push_back(i);
        }
        int a[n];
        copy(v.begin(), v.end(), a);
        do {
            TreeNode *root = new TreeNode(-1);
            for (int i = 0; i < n; i++) {
                TreeNode* node = new TreeNode(a[i]);
                if (root->val == -1) {
                    root = node;
                } else {
                    TreeNode* temp = root;
                    while (temp != nullptr) {
                        if (a[i] < temp->val) {
                            if (temp->left == nullptr) {
                                temp->left = node;
                                break;
                            } else {
                                temp = temp->left;
                            }
                        } else {
                            if(temp->right == nullptr) {
                                temp->right = node;
                                break;
                            } else {
                                temp = temp->right;
                            }
                        }
                    }
                }
            }
            int i;
            for (i = 0; i < treeNode.size(); i++) {
                TreeNode *t = treeNode[i];
                if (compareTree(root, t))
                   break;
            }
            if (i == treeNode.size()) {
                treeNode.push_back(root);
            }
        }while (next_permutation(a, a+n));
        return treeNode;
    }

    bool compareTree(TreeNode* tree1, TreeNode* tree2) {
        if (tree1 == nullptr && tree2 == nullptr) {
            return true;
        }
        if (tree1 == nullptr || tree2 == nullptr) {
            return false;
        }
        if (tree1->val == tree2->val) {
            return compareTree(tree1->left, tree2->left) && compareTree(tree1->right, tree2->right);
        }
        else {
            return false;
        }
    }
};