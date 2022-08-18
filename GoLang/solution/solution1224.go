package solution

func MaxEqualFreq(nums []int) int {
	//数值i出现了多少次
	count := make([]int, 100010)
	//出现次数为i的数值有多少个
	sum := make([]int, 100010)
	//最大出现次数
	max := 0

	ans := 0
	for i := 0; i < len(nums); i++ {
		count[nums[i]]++
		cur := count[nums[i]]
		sum[cur]++
		sum[cur-1]--
		if cur > max {
			max = cur
		}
		//全是出现1次的
		if max == 1 {
			ans = i + 1
		}
		//一个数值单独出现一次
		if max*sum[max] == i {
			ans = i + 1
		}
		//max出现一次，其余都是max-1
		if (max-1)*(sum[max-1])+max == i+1 {
			ans = i + 1
		}
	}
	return ans
}
