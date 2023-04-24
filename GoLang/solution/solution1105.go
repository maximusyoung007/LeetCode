package solution

import "math"

/**
设dp[i]表示第i本书放入书架的最大高度
从第i-1本书逆推，判断i-1本是否可以和第i本合并到一层，如果合并后的高度小于当前的高度，则合并，
如果全都可以合并过来，则两层合并为一层
*/
func MinHeightShelves(books [][]int, shelfWidth int) int {
	n := len(books)
	dp := make([]int, n+1)
	dp[0] = 0
	for i := 1; i < len(dp); i++ {
		dp[i] = math.MaxInt
	}
	for i := 0; i < n; i++ {
		w, h := 0, 0
		for j := i; j >= 0; j-- {
			w += books[j][0]
			if books[j][1] > h {
				h = books[j][1]
			}
			if w > shelfWidth {
				break
			} else {
				if dp[j]+h < dp[i+1] {
					dp[i+1] = dp[j] + h
				}
			}

		}
	}
	return dp[n]
}
