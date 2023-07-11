package solution

import "fmt"

/*
	f[i]表示前i个，以奇数位结尾的最大交替和
	g[i]表示前i个，以偶数位结尾的最大交替和
	对于nums[i],
	如果nums[i]是奇数位且选取，则上一个数一定以偶数结尾，则f[i]=g[i-1]-nums[i],不选取，则f[i]=f[i-1]
	如果nums[i]是偶数位且选取，则上一个数一定以奇数结尾，则g[i]=f[i-1]+nums[i]，不选取，则g[i]=g[i-1]
*/
func maxAlternatingSum(nums []int) int64 {
	f, g := make([]int64, len(nums)+1), make([]int64, len(nums)+1)
	f[0] = 0
	g[0] = 0

	for i := 0; i < len(nums); i++ {
		if g[i]-int64(nums[i]) >= f[i] {
			f[i+1] = g[i] - int64(nums[i])
		} else {
			f[i+1] = f[i]
		}

		if f[i]+int64(nums[i]) >= g[i] {
			g[i+1] = f[i] + int64(nums[i])
		} else {
			g[i+1] = g[i]
		}
	}

	if f[len(nums)] > g[len(nums)] {
		return f[len(nums)]
	} else {
		return g[len(nums)]
	}
}

func Test1911() {
	//nums := []int{4, 2, 5, 3}
	//nums := []int{5, 6, 7, 8}
	nums := []int{6, 2, 1, 1, 4, 5}
	fmt.Println(maxAlternatingSum(nums))
}
