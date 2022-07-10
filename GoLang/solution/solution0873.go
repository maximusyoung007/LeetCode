package solution

func LenLongestFibSubseq(arr []int) int {
	n := len(arr)
	if n == 0 {
		return 0
	}
	m := make(map[int]int)
	for i := 0; i < len(arr); i++ {
		m[arr[i]] = i
	}
	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			dp[i][j] = 2
		}
	}

	res := 0
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			t := arr[j] - arr[i]
			_, ok := m[t]
			if ok {
				k := m[t]
				if k < i {
					dp[i][j] = getMax(dp[i][j], dp[k][i]+1)
				}
			}
			res = getMax(res, dp[i][j])
		}
	}
	if res > 2 {
		return res
	} else {
		return 0
	}
}

func getMax(a int, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}
