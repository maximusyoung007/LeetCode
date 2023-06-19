package solution

import (
	"fmt"
	"math"
)

/**
动态规划
dp[i,j]表示以nums[i]为最后一个，j为模3取余的值，，这些和的最大值
当前为i，前一个为i-1
如果不取当前这一个，则dp[i,j]=dp[i-1,j]
如果取当前这个，则dp[i,j]=dp[i-1, j-nums[i]%3]+nums[i]
j-nums[i]%3可能小于0，j是%3以后的结果，因此可以转化为j+3-nums[i]%3
j+3-nums[i]%3可能大于2，因此可以转化为(j+3-nums[i]%3)%3,
dp[i,j]=dp[i-1,j-nums[i]%3]+nums[i]
边界条件：
dp[-1,0]=0
dp[-1,1]=int.min
dp[-2,1]=int.min
实际记录时，dp[1]表示nums[0],以此类推
*/
func maxSumDivThree(nums []int) int {
	n := len(nums)
	dp := make([][3]int, n+1)
	dp[0][0] = 0
	dp[0][1] = math.MinInt
	dp[0][2] = math.MinInt
	for i := 1; i <= n; i++ {
		for j := 0; j < 3; j++ {
			t1 := dp[i-1][j]
			t2 := dp[i-1][(j+3-nums[i-1]%3)%3] + nums[i-1]
			if t1 > t2 {
				dp[i][j] = t1
			} else {
				dp[i][j] = t2
			}
		}
	}
	return dp[n][0]
}

func Test1262() {
	//nums := []int{3, 6, 5, 1, 8}
	//nums := []int{4}
	nums := []int{1, 2, 3, 4, 4}
	fmt.Println(maxSumDivThree(nums))
}
