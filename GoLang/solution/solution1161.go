package solution

import (
	datastructure "gproject/dataStructure"
	"math"
)

func MaxLevelSum(root *datastructure.TreeNode) int {
	ans := 1
	max := math.MinInt64

	queue := make([]*datastructure.TreeNode, 0)
	queue = append(queue, root)
	level := 1
	for len(queue) != 0 {
		sum := 0
		tq := make([]*datastructure.TreeNode, 0)
		for _, t := range queue {
			sum += t.Val
			if t.Left != nil {
				tq = append(tq, t.Left)
			}
			if t.Right != nil {
				tq = append(tq, t.Right)
			}
		}
		if sum > max {
			max = sum
			ans = level
		}
		queue = tq
		level++
	}
	return ans
}
