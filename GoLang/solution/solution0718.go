package solution

import "fmt"

/*
*
dp[i][j]表示a[i-1],b[j-1]为结尾的公共字串的长度
如果a[i-1]==b[j-1], dp[i][j]=dp[i-1][j-1]+1
如果a[i-1]==b[j-1], dp[i][j]=0
*/
func findLength(nums1 []int, nums2 []int) int {
	n1 := len(nums1)
	n2 := len(nums2)
	dp := make([][]int, n1+1)
	for i := 0; i < n1+1; i++ {
		dp[i] = make([]int, n2+1)
	}
	for i := 0; i < n1; i++ {
		dp[i][0] = 0
	}
	for j := 0; j < n2; j++ {
		dp[0][j] = 0
	}
	res := 0
	for i := 0; i < n1; i++ {
		for j := 0; j < n2; j++ {
			if nums1[i] == nums2[j] {
				dp[i+1][j+1] = dp[i][j] + 1
				if dp[i+1][j+1] > res {
					res = dp[i+1][j+1]
				}
			} else {
				dp[i+1][j+1] = 0
			}
		}
	}
	return res
}

func Test0718() {
	//nums1 := []int{1, 2, 3, 2, 1}
	//nums2 := []int{3, 2, 1, 4, 7}
	nums1 := []int{0, 0, 0, 0, 0}
	nums2 := []int{0, 0, 0, 0, 0}
	fmt.Println(findLength(nums1, nums2))
}
