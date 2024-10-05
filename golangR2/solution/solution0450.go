package solution

func DeleteNode(root *TreeNode, key int) *TreeNode {
	if root == nil {
		return root
	}
	//大于root，向右递归
	if key > root.Val {
		root.Right = DeleteNode(root.Right, key)
	}
	//小于root，向左递归
	if key < root.Val {
		root.Left = DeleteNode(root.Left, key)
	}

	//等于，则删除当前节点
	//如果左子树为空，则右子树顶替其位置
	//如果右子树为空，则左子树顶替其位置
	//如果左子树和右子树都不为空，则左子树顶替其位置，并将左子树最右边的节点的右指针指向右子树（右子树顶替也可以，画个图就很简单了）
	/**
				4                        2
			2     	6       --->     1      3
	 	1 	   3  5    7                        6
		                                      5   7
	*/
	if key == root.Val {
		if root.Left == nil && root.Right != nil {
			return root.Right
		}
		if root.Right == nil && root.Left != nil {
			return root.Left
		}
		if root.Left != nil || root.Right != nil {
			t := root.Left
			for t.Right != nil {
				t = t.Right
			}
			t.Right = root.Right
			return root.Left
		}
		if root.Left == nil && root.Right == nil {
			return nil
		}
	}

	return root
}
