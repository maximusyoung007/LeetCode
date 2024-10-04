package solution

func FindTarget(root *TreeNode, k int) bool {

	m := make(map[int]int)

	var ft func(root *TreeNode, k int, m map[int]int) bool

	ft = func(root *TreeNode, k int, m map[int]int) bool {
		if root == nil {
			return false
		}

		_, ok := m[k-root.Val]
		if ok {
			return true
		}
		m[root.Val] = root.Val

		return ft(root.Left, k, m) || ft(root.Right, k, m)

	}

	return ft(root, k, m)

}
