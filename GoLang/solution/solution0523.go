package solution

import "fmt"

/**
nums[i,j]是k的倍数， 则nums[i,j]%k==0
(sum[j]-sum[i])%k == 0
sum[j]%k = sum[i]%k

*/
func checkSubarraySum(nums []int, k int) bool {
	sum := make([]int, len(nums)+1)
	for i := 1; i < len(nums)+1; i++ {
		sum[i] = sum[i-1] + nums[i-1]
	}

	m := make(map[int]int)
	for i := 0; i < len(sum); i++ {
		j, ok := m[sum[i]%k]
		if ok {
			if i-j >= 2 {
				return true
			}
		} else {
			m[sum[i]%k] = i
		}
	}
	return false
}

func Test0523() {
	//nums := []int{23, 2, 4, 6, 7}
	//k := 6
	//nums := []int{23, 2, 6, 4, 7}
	//k := 6
	nums := []int{23, 2, 6, 4, 7}
	k := 13
	//nums := []int{23, 0, 0}
	//k := 6
	//nums := []int{23, 2, 4, 6, 6}
	//k := 7
	fmt.Println(checkSubarraySum(nums, k))
}
