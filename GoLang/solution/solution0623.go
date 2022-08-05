package solution

import datastructure "gproject/dataStructure"

func AddOneRow(root *datastructure.TreeNode, val int, depth int) *datastructure.TreeNode {
	if depth == 1 {
		node := &datastructure.TreeNode{Val: val, Left: root, Right: nil}
		return node
	} else {
		queue := make([]*datastructure.TreeNode, 0)
		queue = append(queue, root)
		cur := 1
		for len(queue) > 0 {
			l := len(queue)
			for l > 0 {
				t := queue[0]
				queue = queue[1:]
				if cur == depth-1 {
					a := &datastructure.TreeNode{Val: val, Left: nil, Right: nil}
					b := &datastructure.TreeNode{Val: val, Left: nil, Right: nil}
					a.Left = t.Left
					b.Right = t.Right
					t.Left = a
					t.Right = b
				} else {
					if t.Left != nil {
						queue = append(queue, t.Left)
					}
					if t.Right != nil {
						queue = append(queue, t.Right)
					}
				}
				l--
			}
			cur++
		}
		return root
	}
}
