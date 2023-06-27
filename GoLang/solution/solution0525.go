package solution

import "fmt"

/*
将0替换为-1
如果-1和1的数量相等，则nums[i,j]=0
nums[i,j] = sum[j]-sum[i] = 0
sum[j] = sum[i]
*/
func findMaxLength(nums []int) int {
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			nums[i] = -1
		}
	}
	sum := make([]int, len(nums)+1)
	res := 0
	m := make(map[int]int, 0)
	for i := 0; i < len(sum); i++ {
		if i != 0 {
			sum[i] = sum[i-1] + nums[i-1]
		}
		j, ok := m[sum[i]]
		if ok {
			if i-j > res {
				res = i - j
			}
		} else {
			m[sum[i]] = i
		}
	}
	return res
}

func Test0525() {
	//nums := []int{0, 1}
	//nums := []int{0, 1, 0}
	nums := []int{0, 0, 1, 0, 0, 0, 1, 1}
	fmt.Println(findMaxLength(nums))
}
