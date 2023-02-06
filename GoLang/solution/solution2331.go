package solution

import datastructure "gproject/dataStructure"

// 递归
func evaluateTree(root *datastructure.TreeNode) bool {
	if root.Left == nil {
		return root.Val == 1
	} else {
		if root.Val == 3 {
			return evaluateTree(root.Left) && evaluateTree(root.Right)
		} else {
			return evaluateTree(root.Left) || evaluateTree(root.Right)
		}
	}
}
