package solution

func LowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var lca func(root, p, q *TreeNode) *TreeNode
	lca = func(root, p, q *TreeNode) *TreeNode {
		if root == nil || root.Val == p.Val || root.Val == q.Val {
			return root
		}
		root.Left = lca(root.Left, p, q)
		root.Right = lca(root.Right, p, q)

		//如果左边也能找到相等的，右边也能找到相等的, 则表示当前节点就是最近公共祖先
		if root.Left != nil && root.Right != nil {
			return root
		}

		if root.Left != nil {
			return root.Left
		} else {
			return root.Right
		}
	}

	return lca(root, p, q)
}
