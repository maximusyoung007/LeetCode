package solution

func PostorderTraversal(root *TreeNode) []int {
	stack := make([]*TreeNode, 0)
	res := make([]int, 0)

	//pre用来记录右节点，避免右节点重复入队， 如果当前节点的右节点等于上一轮进入过结果集的节点，就不用再重复入栈了
	var pre *TreeNode
	for root != nil || len(stack) != 0 {
		//先持续向左
		for root != nil {
			stack = append(stack, root)
			root = root.Left
		}

		root = stack[len(stack)-1]
		stack = stack[0 : len(stack)-1]

		//如果当前节点没有右节点，就表示是左节点，加入到结果集中
		//如果有右节点，则根节点重新入队，并向右迭代
		if root.Right == nil || root.Right == pre {
			res = append(res, root.Val)
			pre = root
			root = nil
		} else {
			stack = append(stack, root)
			root = root.Right
		}
	}

	return res
}
