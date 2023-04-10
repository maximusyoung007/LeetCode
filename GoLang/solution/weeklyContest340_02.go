package solution

/*
*
思路1：map存num[i]对应的下标队列，每次有一个数进来以后更新这个队列，超时
思路2：存map后用前缀和
i左边的距离=a[i]-a[0]+a[i]-a[1]+...+a[i]-a[i-1]=(i*a[i])-(a[0]+a[1]+...a[i-1])=i*a[i]-preSum[i-1]
i右边的距离=a[i+1]-a[i]+a[i+2]-a[i]+...a[n-1]-a[i]=preSum[n-1]-preSum[i]-(n-1-i)*a[i]
*/
func Distance(nums []int) []int64 {
	m := make(map[int][]int, 0)
	res := make([]int64, len(nums))
	for i := 0; i < len(nums); i++ {
		_, ok := m[nums[i]]
		if ok {
			m[nums[i]] = append(m[nums[i]], i)
		} else {
			m[nums[i]] = []int{i}
		}
	}

	for _, v := range m {
		arr := v
		preSum := make([]int, len(arr))
		for i, a := range arr {
			if i == 0 {
				preSum[i] = a
			} else {
				preSum[i] = preSum[i-1] + a
			}
		}

		for i := 0; i < len(arr); i++ {
			left, right := 0, 0
			if i != 0 {
				left = i*arr[i] - preSum[i-1]
			}
			right = preSum[len(arr)-1] - preSum[i] - (len(arr)-1-i)*arr[i]
			res[arr[i]] = int64(left + right)
		}
	}

	return res
}
