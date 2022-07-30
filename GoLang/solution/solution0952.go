package solution

import "math"

//宫水三叶 答案golang版
//https://leetcode.cn/problems/largest-component-size-by-common-factor/solution/by-ac_oier-mw04/
//全局变量要在方法里初始化，不然过不了
var p []int
var sz []int
var ans int

func LargestComponentSize(nums []int) int {
	n := len(nums)
	m := make(map[int][]int, 0)
	p = make([]int, n+1)
	sz = make([]int, n+1)
	ans = 1
	for i := 0; i < n; i++ {
		cur := nums[i]
		for j := 2; j*j <= cur; j++ {
			if cur%j == 0 {
				add(m, j, i)
			}
			for cur%j == 0 {
				cur /= j
			}
		}
		if cur > 1 {
			add(m, cur, i)
		}
	}
	for i := 0; i <= n; i++ {
		p[i] = i
		sz[i] = 1
	}
	for key, _ := range m {
		list := m[key]
		for i := 1; i < len(list); i++ {
			union(list[0], list[i])
		}
	}
	return ans
}

func find(x int) int {
	if p[x] != x {
		p[x] = find(p[x])
	}
	return p[x]
}

func union(a int, b int) {
	if find(a) == find(b) {
		return
	}
	sz[find(a)] += sz[find(b)]
	p[find(b)] = p[find(a)]
	ans = int(math.Max(float64(ans), float64(sz[find(a)])))
}

func add(m map[int][]int, key int, val int) {
	list, ok := m[key]
	if !ok {
		list = make([]int, 0)
	}
	list = append(list, val)
	m[key] = list
}
