package solution

import "math"

func GetMinimumDifference(root *TreeNode) int {
	pre, res := -1, math.MaxInt
	minDiff(root, &pre, &res)
	return res
}

func minDiff(root *TreeNode, pre *int, res *int) {
	if root == nil {
		return
	}

	minDiff(root.Left, pre, res)

	if *pre == -1 {
		*pre = root.Val
	} else {
		if root.Val-*pre < *res {
			*res = root.Val - *pre
		}
		*pre = root.Val
	}

	minDiff(root.Right, pre, res)
}
