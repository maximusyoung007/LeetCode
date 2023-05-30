package solution

import datastructure "gproject/dataStructure"

func delNodes(root *datastructure.TreeNode, to_delete []int) []*datastructure.TreeNode {
	deleteMap := make(map[int]bool)
	for _, v := range to_delete {
		deleteMap[v] = true
	}
	res := make([]*datastructure.TreeNode, 0)
	dfs1110(root, deleteMap, &res, true)
	return res

}

func dfs1110(node *datastructure.TreeNode, deleteMap map[int]bool, res *[]*datastructure.TreeNode, isRoot bool) *datastructure.TreeNode {
	if node == nil {
		return nil
	}
	deleted := deleteMap[node.Val]
	node.Left = dfs1110(node.Left, deleteMap, res, deleted)
	node.Right = dfs1110(node.Right, deleteMap, res, deleted)
	if deleted {
		return nil
	} else {
		if isRoot {
			*res = append(*res, node)
		}
		return node
	}
}
