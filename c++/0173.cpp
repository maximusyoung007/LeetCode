#include"tree.h"
#include<vector>
using namespace std;

class BSTIterator {
public:
    int i = 0;
    vector<int> v;
    void inOrder(TreeNode* treeNode, vector<int>& v) {
        if (treeNode == nullptr) {
            return;
        }
        inOrder(treeNode->left, v);
        v.push_back(treeNode->val);
        inOrder(treeNode->right, v);
    }
    vector<int> getInOrder(TreeNode* treeNode) {
        vector<int> v2;
        inOrder(treeNode, v2);
        return v2;
    }
    BSTIterator(TreeNode* root) : i(0), v(getInOrder(root)){}

    int next() {
        return v[i++];
    }

    bool hasNext() {
        return i < v.size();
    }
};