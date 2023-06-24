package solution

import "fmt"

/*
*
求前缀和，判断(sums[j]-sums[i])%k是否等于0，即sums[j]%k - sums[i]%k是否等于0
所以有sums[j]%k==sums[i]%k
存储sums[i]%k，如果已经存过了，则之前存的每一个，可以和当前的值可以组成一对
*/
func subarraysDivByK(nums []int, k int) int {
	preSum := make([]int, len(nums)+1)
	m := make(map[int]int, 0)
	m[0] = 1
	res := 0
	for i := 1; i < len(nums)+1; i++ {
		preSum[i] = preSum[i-1] + nums[i-1]
		t := (preSum[i]%k + k) % k
		_, ok := m[t]
		if ok {
			res += m[t]
			m[t]++
		} else {
			m[t] = 1
		}
	}
	return res
}

func Test0974() {
	nums := []int{4, 5, 0, -2, -3, 1}
	k := 5
	//nums := []int{5}
	//k := 9
	fmt.Println(subarraysDivByK(nums, k))
	//fmt.Println(0 % 5)
}
