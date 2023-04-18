package solution

import (
	datastructure "gproject/dataStructure"
	"math"
)

func maxAncestorDiff(root *datastructure.TreeNode) int {
	return dfs1026(root, root.Val, root.Val)
}

func dfs1026(root *datastructure.TreeNode, max int, min int) int {
	if root == nil {
		return 0
	}
	diff := 0
	if math.Abs(float64(root.Val-max)) > math.Abs(float64(root.Val-min)) {
		diff = int(math.Abs(float64(root.Val - max)))
	} else {
		diff = int(math.Abs(float64(root.Val - min)))
	}
	if root.Val > max {
		max = root.Val
	}
	if root.Val < min {
		min = root.Val
	}
	diffLeft := dfs1026(root.Left, max, min)
	diffRight := dfs1026(root.Right, max, min)
	if diffLeft > diff {
		diff = diffLeft
	}
	if diffRight > diff {
		diff = diffRight
	}
	return diff
}
