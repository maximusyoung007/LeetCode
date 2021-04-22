/**
 * 156. 上下翻转二叉树
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树，
 * 原来的右节点将转换成左叶节点。返回新的根。
    例子:
输入: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

输出: 返回二叉树的根 [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-upside-down
 */
#include"tree.h"
using namespace std;

class Solution0156 {
public:
    TreeNode* upsideDownBinaryTree(TreeNode* root) {
        TreeNode* right = nullptr, *father = nullptr;
        while(root != nullptr) {
            TreeNode* left = root->left;
            root->left = right;
            right = root->right;
            root->right = father;
            father = root;
            root = left;
        }
        return father;
    }
};