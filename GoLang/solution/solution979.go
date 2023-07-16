package solution

import (
	"fmt"
	datastructure "gproject/dataStructure"
)

/*
dfs[left]表示节点到其左子树的边的值，表示左子树多余的或者缺失的金币个数
dfs[right]表示节点到其右子树的边的值，表示右子树多余的或者缺少的金币个数
对于根节点说，左子树多（少）的树+右子树多（少）的树+根节点的金币-1=0
需要注意的是，在计算多余或者缺失的金币个数的时候，左子树和右子树金币个数可能有负数
比如左子树多两个金币，右子树少两个金币，根节点有一个金币，相加刚好为0，表示整棵树所有的金币恰好可以放在每个节点上（符合题意）

一棵子树到其父节点的值，等于这棵树的左子树的金币个数+右子树的金币个数+根节点的金币个数-1，-1表示留一个给根节点

但是计算路径长度的时候，全换成正数计算，最终的路径长度是所有的边之和
*/
func distributeCoins(root *datastructure.TreeNode) int {
	res := 0
	var dfs func(node *datastructure.TreeNode) int
	dfs = func(node *datastructure.TreeNode) int {
		if node == nil {
			return 0
		}
		left := dfs(node.Left)
		right := dfs(node.Right)
		//计算多出或者缺失的金币，有正有负
		ans := left + right + node.Val - 1
		if left < 0 {
			left = -left
		}
		if right < 0 {
			right = -right
		}
		//计算要移动的次数，全是正数
		res = res + left + right
		return ans
	}
	dfs(root)
	return res
}

func Test979() {
	//root3 := &datastructure.TreeNode{Val: 3, Left: nil, Right: nil}
	//root1 := &datastructure.TreeNode{0, nil, root3}
	//root2 := &datastructure.TreeNode{0, nil, nil}
	//root0 := &datastructure.TreeNode{Val: 1, Left: root1, Right: root2}
	//fmt.Println(distributeCoins(root0))
	root3 := &datastructure.TreeNode{0, nil, nil}
	root2 := &datastructure.TreeNode{0, nil, root3}
	root1 := &datastructure.TreeNode{0, nil, root2}
	root0 := &datastructure.TreeNode{4, root1, nil}
	fmt.Println(distributeCoins(root0))
}
