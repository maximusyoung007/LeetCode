package solution

import (
    "gproject/dataStructure"
)

/*
计算给定二叉树的所有左叶子之和。
示例：
    3
   / \
  9  20
    /  \
   15   7
在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
*/
// type TreeNode struct {
// 	Val int
// 	Left *TreeNode
// 	Right *TreeNode
// }

func SumOfLeftLeaves(root *datastructure.TreeNode) int {
    sum := 0
    preOrder(&sum, root)
    return sum
}

func preOrder(sum *int, node *datastructure.TreeNode) {
    if node == nil {
        return
    } else {
        if node.Left != nil && node.Left.Left == nil && node.Left.Right == nil {
			*sum = *sum + node.Left.Val
		}
	}
	preOrder(sum, node.Left)
	preOrder(sum, node.Right)
}
