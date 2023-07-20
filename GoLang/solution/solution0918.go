package solution

import (
	"fmt"
)

/*dp1表示以i结尾的最大子数组的长度
dp2表示最小的子数组的长度
有两种情况
情况一：没有跨越首尾，最大的子数组就是正常顺序中的一个
情况二：跨越首尾，最大的子数组就是整个数组的和减去最小子数组的和
比较情况一和情况二,选出更大的那个
*/
func maxSubarraySumCircular(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}

	res, dp, sum := nums[0], nums[0], nums[0]
	for i := 1; i < len(nums); i++ {
		sum += nums[i]
		if dp+nums[i] > nums[i] {
			dp = dp + nums[i]
		} else {
			dp = nums[i]
		}
		if dp > res {
			res = dp
		}
	}

	//如果跨越首尾，那么首尾元素一定在子数组中，所以计算最小值从第二个开始，到倒数第二个结束
	dp = nums[1]
	mi := nums[1]
	for i := 2; i < len(nums)-1; i++ {
		if dp+nums[i] < nums[i] {
			dp = dp + nums[i]
		} else {
			dp = nums[i]
		}
		if dp < mi {
			mi = dp
		}
	}

	if sum-mi > res {
		res = sum - mi
	}

	return res
}

func Test0918() {
	//nums := []int{1, -2, 3, -2}
	//nums := []int{5, -3, 5}
	//nums := []int{-2, -2, -3}
	//nums := []int{-2}
	nums := []int{8, -15, -29, -19}
	fmt.Println(maxSubarraySumCircular(nums))
}
