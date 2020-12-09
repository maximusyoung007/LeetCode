#ifndef C___TREE_H
#define C___TREE_H
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0) ,left(nullptr),right(nullptr) {}
    TreeNode(int x) : val(x) ,left(nullptr),right(nullptr) {}
    TreeNode(int x,TreeNode *left,TreeNode *right) : val(x),left(left),right(right){}
};
#endif //C___TREE_H