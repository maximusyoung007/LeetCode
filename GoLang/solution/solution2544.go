package solution

import "fmt"

func alternateDigitSum(n int) int {
	nums := make([]int, 0)
	for n > 0 {
		num := n % 10
		n = n / 10
		nums = append(nums, num)
	}

	res, index := 0, -1
	for i := len(nums) - 1; i >= 0; i-- {
		res += nums[i] * (-1) * index
		index = -index
	}
	return res
}

func Test2544() {
	fmt.Println(alternateDigitSum(521))
	fmt.Println(alternateDigitSum(111))
	fmt.Println(alternateDigitSum(886996))
}
