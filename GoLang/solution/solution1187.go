package solution

import (
	"math"
	"sort"
)

/*
dp[i][j]表示arr1中前i个数组进行j次替换后 组成严格递增子数组的末尾元素的最小值
遍历到第i个数组时
若a[i] > dp[i-1][j],则a[i]可以保留，dp[i][j] = min(dp[i][j], arr[i])
若a[i]需要替换，在arr2中找到大于dp[i-1][j-1]的最小元素arr2[k],则dp[i][j]=min(dp[i][j],arr2[k])
dp[i][j]=maxInt
dp[0][0]=0
*/
func MakeArrayIncreasing(arr1 []int, arr2 []int) int {
	//排序并删除数组中重复元素
	sort.Ints(arr2)
	for i := 0; i < len(arr2); i++ {
		if i+1 < len(arr2) && arr2[i] == arr2[i+1] {
			arr2 = append(arr2[:i], arr2[i+1:]...)
			i--
		}
	}

	startValue := math.MaxInt
	m, n := len(arr1), len(arr2)
	dp := make([][]int, m+1)
	if m < n {
		n = m
	}
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
	}
	for i := 0; i <= m; i++ {
		for j := 0; j <= n; j++ {
			dp[i][j] = startValue
		}
	}
	dp[0][0] = -1

	for i := 1; i <= m; i++ {
		jIndex := 0
		if i < n {
			jIndex = i
		} else {
			jIndex = n
		}
		for j := 0; j <= jIndex; j++ {
			if arr1[i-1] > dp[i-1][j] {
				dp[i][j] = arr1[i-1]
			}
			if j > 0 && dp[i-1][j-1] != startValue {
				index := binarySearch(arr2, j-1, dp[i-1][j-1])
				if index != len(arr2) {
					if arr2[index] < dp[i][j] {
						dp[i][j] = arr2[index]
					}
				}
			}
			if i == m && dp[i][j] != startValue {
				return j
			}
		}
	}
	return -1
}

func binarySearch(arr []int, low int, target int) int {
	high := len(arr)
	for low < high {
		mid := low + (high-low)/2
		if arr[mid] > target {
			high = mid
		} else {
			low = mid + 1
		}
	}
	return low
}
