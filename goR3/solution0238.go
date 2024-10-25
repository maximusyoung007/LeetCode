package main

func ProductExceptSelf(nums []int) []int {
    n := len(nums)
	prefix := make([]int, n)
	suffix := make([]int, n)

	//计算每个位置的前缀积和后缀积,结果即为两积相乘
	for i := 0; i < n; i++ {
		if i == 0 {
			prefix[i] = 1
			suffix[n-1-i] = 1
			continue
		}

		prefix[i] = prefix[i-1] * nums[i-1]
		suffix[n-1-i] = suffix[n-i] * nums[n-i]
	}

	res := make([]int, n)

	for i := 0; i < n; i++ {
		res[i] = prefix[i] * suffix[i]
	}

	return res
}