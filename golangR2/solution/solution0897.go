package solution

func IncreasingBST(root *TreeNode) *TreeNode {
	res := TreeNode{Val: -1}
	t := &res
	var ib func(root *TreeNode)

	ib = func(root *TreeNode) {
		if root == nil {
			return
		}
		ib(root.Left)
		t.Right = root
		root.Left = nil
		t = t.Right
		ib(root.Right)
	}

	ib(root)

	return res.Right
}
