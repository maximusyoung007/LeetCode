package solution

/* g[i]表示以i结尾的满足条件的数量
以1，2，3，4，5为例，
以4结尾的满足条件的数列为1，2，3，4和2，3，4
如果以5为结尾的等差数列满足条件，那么会有三个，即在1，2，3，4和2，3，4基础上加5，得到1，2，3，4，5和2，3，4，5
还有一个新出现的3，4，5，共有三个，得到规律，如果num[i-2]-nums[i-1]==nums[i-1]-nums[i],那么g[i]=g[i-1]+1
*/

func NumberOfArithmeticSlices(nums []int) int {
	n := len(nums)
	if n == 1 {
		return 0
	}
	g := make([]int, n)
	g[0], g[1] = 0, 0

	for i := 2; i < len(nums); i++ {
		if nums[i-2]-nums[i-1] == nums[i-1]-nums[i] {
			g[i] = g[i-1] + 1
		} else {
			g[i] = 0
		}
	}

	sum := 0
	for _, num := range g {
		sum += num
	}

	return sum
}
