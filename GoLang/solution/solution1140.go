package solution

import "math"

/*
*
从后往前递推,因为最右边的情况是固定的
dp[i][j]表示剩余[i:len-1]堆时，M=j的情况，可以获得的石子个数
每次M从1开始计算
1、i+2M>=len,说明剩下的可以全部拿走，最优情况就是剩下的右石子和
2、i+2M<len，，下一个从i+x开始拿，并且下一次拿的m=max(m,x),那么当前次拿的就是 dp[i][M] = max(dp[i][M], sum[i:len-1]-dp[i+x][max(x,M)]
*/
func StoneGameII(piles []int) int {
	lens := len(piles)
	dp := make([][]int, lens)
	for i := 0; i < lens; i++ {
		dp[i] = make([]int, lens*2+1)
	}
	for i := lens - 1; i >= 0; i-- {
		for m := 1; m <= lens; m++ {
			if i+2*m >= lens {
				dp[i][m] = sums(i, lens-1, piles)
			} else {
				//这里已知x <= 2 * m
				for x := 1; x <= 2*m; x++ {
					dp[i][m] = max(dp[i][m], sums(i, lens-1, piles)-dp[i+x][max(x, m)])
				}
			}
		}
	}
	return dp[0][1]
}

func sums(left int, right int, piles []int) int {
	res := 0
	for i := left; i <= right; i++ {
		res += piles[i]
	}
	return res
}

func max(a int, b int) int {
	af := float64(a)
	bf := float64(b)
	r := math.Max(af, bf)
	return int(r)
}
