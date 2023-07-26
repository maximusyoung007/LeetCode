package solution

import "fmt"

func handleQuery(nums1 []int, nums2 []int, queries [][]int) []int64 {
	res := make([]int64, 0)
	n := int64(len(nums1))
	tree1 := make([]handleTree, 4*n)
	tree2 := make([]handleTree, 4*n)
	buildTree(tree1, nums1, 1, 0, n-1)
	buildTree(tree2, nums2, 1, 0, n-1)
	for i := 0; i < len(queries); i++ {
		querie := queries[i]
		if querie[0] == 2 {
			update2(tree1, tree2, 1, 0, n-1, querie[1])
			if i+1 < len(queries) {
				querie1 := queries[i+1]
				if querie1[0] == 3 {
					t := queryTree2(tree1, tree2, 1, 0, n-1, querie[1])
					res = append(res, t)
					i++
				}
			} else {
				queryTree2(tree1, tree2, 1, 0, n-1, querie[1])
			}
		}
		if querie[0] == 1 {
			update1(tree1, 1, int64(querie[1]), int64(querie[2]))
			if i+1 < len(queries) {
				querie1 := queries[i+1]
				if querie1[0] == 3 {
					//遍历更改querie的值
					queryTree1(tree1, 1, int64(querie[1]), int64(querie[2]))
					t := queryTree2(tree1, tree2, 1, 0, n-1, 0)
					res = append(res, t)
					i++
				}
			} else {
				queryTree1(tree1, 1, int64(querie[1]), int64(querie[2]))
			}
		}
		if querie[0] == 3 {
			t := queryTree2(tree1, tree2, 1, 0, n-1, 0)
			res = append(res, t)
		}
	}

	return res
}

func buildTree(tree []handleTree, nums []int, id int64, l int64, r int64) {
	tree[id].left = l
	tree[id].right = r
	if l == r {
		tree[id].sum = int64(nums[l])
	} else {
		mid := (l + r) / 2
		buildTree(tree, nums, id*2, l, mid)
		buildTree(tree, nums, id*2+1, mid+1, r)
		tree[id].sum = tree[id*2].sum + tree[id*2+1].sum
	}
	//惰性标识初始化为0
	tree[id].lazy = 0
}

// 区间查询和，从叶子结点向上递归
func queryTree2(tree1 []handleTree, tree2 []handleTree, id int, l int64, r int64, p int) int64 {
	if tree2[id].left == l && tree2[id].right == r {
		return tree2[id].sum
	} else if tree2[id].left == tree2[id].right {
		//到叶子节点了，返回
		return tree2[id].sum
	} else {
		mid := (tree2[id].left + tree2[id].right) / 2
		if tree2[id].lazy == 2 {
			tree2[id*2].sum = tree1[id*2].sum*int64(p) + tree2[id*2].sum
			tree2[id*2+1].sum = tree1[id*2+1].sum*int64(p) + tree2[id*2+1].sum
			tree2[id].lazy = 2
			tree2[id].lazy = 2
			tree2[id].lazy = 0
		}
		if r <= mid {
			return queryTree2(tree1, tree2, id*2, l, r, p)
		} else if l > mid {
			return queryTree2(tree1, tree2, id*2+1, l, r, p)
		} else {
			return queryTree2(tree1, tree2, id*2, l, mid, p) + queryTree2(tree1, tree2, id*2+1, mid, r, p)
		}
	}
}

func update2(tree1 []handleTree, tree2 []handleTree, id int, l int64, r int64, p int) {
	if l > tree2[id].right || r < tree2[id].left {
		return
	}
	if tree2[id].left >= l && tree2[id].right <= r {
		//当前节点的区间全在待更新的范围内
		tree2[id].sum = tree1[id].sum*int64(p) + tree2[id].sum
		tree2[id].lazy = 2
		return
	} else {
		update2(tree1, tree2, id*2, l, r, p)
		update2(tree1, tree2, id*2+1, l, r, p)
		tree2[id].sum = tree2[id*2].sum + tree2[id*2+1].sum
	}
}

func update1(tree1 []handleTree, id int, l int64, r int64) {
	if l > tree1[id].right || r < tree1[id].left {
		return
	}
	if tree1[id].left >= l && tree1[id].right <= r {
		tree1[id].sum = tree1[id].right - tree1[id].left + 1 - tree1[id].sum
		tree1[id].lazy = 1
		return
	} else {
		update1(tree1, id*2, l, r)
		update1(tree1, id*2+1, l, r)
		tree1[id].sum = tree1[id*2].sum + tree1[id*2+1].sum
	}
}

func queryTree1(tree1 []handleTree, id int, l int64, r int64) int64 {
	if tree1[id].left == l && tree1[id].right == r {
		return tree1[id].sum
	} else if tree1[id].left == tree1[id].right {
		//到叶子节点了，返回
		return tree1[id].sum
	} else {
		mid := (tree1[id].left + tree1[id].right) / 2
		if tree1[id].lazy == 1 {
			tree1[id*2].sum = tree1[id*2].right - tree1[id*2].left + 1 - tree1[id*2].sum
			tree1[id*2+1].sum = tree1[id*2+1].right - tree1[id*2+1].left + 1 - tree1[id*2+1].sum
			tree1[id].lazy = 1
			tree1[id].lazy = 1
			tree1[id].lazy = 0
		}
		if r <= mid {
			return queryTree1(tree1, id*2, l, r)
		} else if l > mid {
			return queryTree1(tree1, id*2+1, l, r)
		} else {
			return queryTree1(tree1, id*2, l, mid) + queryTree1(tree1, id*2+1, mid, r)
		}
	}
}

type handleTree struct {
	left, right int64
	sum         int64
	lazy        int64
}

func Test2569() {
	//nums1 := []int{1, 0, 1}
	//nums1 := []int{1, 1, 1, 1, 1}
	//nums2 := []int{10, 11, 12, 13, 14}
	//nums1 := []int{1}
	//nums2 := []int{5}
	//queries := [][]int{{2, 0, 0}, {3, 0, 0}}
	//nums1 := []int{1, 0, 1}
	//nums2 := []int{0, 0, 0}
	//queries := [][]int{{1, 1, 1}, {2, 1, 0}, {3, 0, 0}}
	nums1 := []int{1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0}
	nums2 := []int{48, 2, 32, 25, 30, 37, 32, 18, 48, 39, 34, 19, 46, 43, 30, 22, 20, 35, 28, 3, 5, 45, 39, 21, 46, 45, 12, 15}
	queries := [][]int{{3, 0, 0}, {2, 3, 0}, {1, 10, 26}, {2, 4, 0}, {2, 18, 0}}
	fmt.Println(handleQuery(nums1, nums2, queries))
}
