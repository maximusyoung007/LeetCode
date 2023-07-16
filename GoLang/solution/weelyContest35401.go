package solution

import "fmt"

func sumOfSquares(nums []int) int {
	res, n := 0, len(nums)
	for i := 0; i < n; i++ {
		if n%(i+1) == 0 {
			res += nums[i] * nums[i]
		}
	}
	return res
}

func Test35401() {
	nums := []int{1, 2, 3, 4}
	fmt.Println(sumOfSquares(nums))
}
