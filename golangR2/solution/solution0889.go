package solution

func ConstructFromPrePost(preorder []int, postorder []int) *TreeNode {
	var cfpp func(preorder []int, postorder []int) *TreeNode
	cfpp = func(preorder []int, postorder []int) *TreeNode {
		var root TreeNode

		if len(preorder) == 2 {
			root = TreeNode{Val: preorder[0]}
			l := TreeNode{Val: preorder[1]}
			root.Left = &l
			return &root
		}

		if len(preorder) == 1 {
			root = TreeNode{Val: preorder[0]}
			return &root
		}

		if len(preorder) == 0 {
			return nil
		}

		//因为是前序遍历，所以preorder[0]为根节点，preorder[1]为左子树根节点
		//查找preorder[1]在后序遍历的位置，即为左右子树分界位置
		val := preorder[1]
		index := -1

		for i := 0; i < len(postorder); i++ {
			if postorder[i] == val {
				index = i
			}
		}

		root = TreeNode{Val: preorder[0]}

		postorder1 := postorder[0 : index+1]
		postorder2 := postorder[index+1 : len(postorder)-1]

		preorder1 := preorder[1 : len(postorder1)+1]
		preorder2 := preorder[len(postorder1)+1:]

		root.Left = cfpp(preorder1, postorder1)
		root.Right = cfpp(preorder2, postorder2)

		return &root
	}

	return cfpp(preorder, postorder)

}
