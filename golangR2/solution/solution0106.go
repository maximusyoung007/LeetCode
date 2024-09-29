package solution

func BuildTree(inorder []int, postorder []int) *TreeNode {
	var bf func(inorder []int, postorder []int) *TreeNode
	bf = func(inorder []int, postorder []int) *TreeNode {
		var root TreeNode
		if len(inorder) == 1 {
			return &TreeNode{Val: inorder[0]}
		}

		if len(inorder) == 2 {
			root = TreeNode{Val: postorder[1]}
			if root.Val == inorder[0] {
				r := TreeNode{Val: inorder[1]}
				root.Right = &r
			} else {
				l := TreeNode{Val: postorder[0]}
				root.Left = &l
			}
			return &root
		}

		if len(inorder) == 3 {
			root = TreeNode{Val: postorder[2]}
			l := TreeNode{Val: postorder[0]}
			r := TreeNode{Val: postorder[1]}
			root.Left = &l
			root.Right = &r
			return &root
		}

		val := postorder[len(postorder)-1]
		index := -1

		for i := 0; i < len(inorder); i++ {
			if inorder[i] == val {
				index = i
			}
		}

		root.Val = val
		inorder1 := inorder[0:index]
		inorder2 := inorder[index+1:]

		postorder1 := postorder[0:len(inorder1)]
		postorder2 := postorder[len(inorder1) : len(postorder)-1]

		root.Left = bf(inorder1, postorder1)
		root.Right = bf(inorder2, postorder2)

		return &root
	}

	return bf(inorder, postorder)
}
