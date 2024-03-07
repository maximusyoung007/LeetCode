package solution

// 假设爬到第n个台阶有g(n)种方案，g(n)=g(n-1)+g(n-2)
func ClimbStairs(n int) int {
	g := make([]int, n+1)
	if n == 1 || n == 2 {
		return n
	}
	g[1] = 1
	g[2] = 2

	for i := 3; i <= n; i++ {
		g[i] = g[i-1] + g[i-2]
	}

	return g[n]
}
