package solution

import datastructure "gproject/dataStructure"

type CBTInserter struct {
	root  *datastructure.TreeNode
	queue []*datastructure.TreeNode
}

func Constructor0919(root *datastructure.TreeNode) CBTInserter {
	queue := []*datastructure.TreeNode{}
	q := []*datastructure.TreeNode{root}
	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		if node.Left != nil {
			q = append(q, node.Left)
		}
		if node.Right != nil {
			q = append(q, node.Right)
		}
		if node.Left == nil || node.Right == nil {
			queue = append(queue, node)
		}
	}
	return CBTInserter{root: root, queue: queue}
}

func (this *CBTInserter) Insert(val int) int {
	node := &datastructure.TreeNode{Val: val}
	t := this.queue[0]
	if t.Left == nil {
		this.queue[0].Left = node
	} else if t.Right == nil {
		this.queue[0].Right = node
		this.queue = this.queue[1:]
	}
	this.queue = append(this.queue, node)
	return t.Val
}

func (this *CBTInserter) Get_root() *datastructure.TreeNode {
	return this.root
}
