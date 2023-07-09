package solution

import "fmt"

func maximumJumps(nums []int, target int) int {
	//res := 0
	//queue := make([]int, 0)
	//queue = append(queue, 0)
	//res, t := -1, 0
	//for len(queue) > 0 {
	//	n := len(queue)
	//	t++
	//	for k := 0; k < n; k++ {
	//		i := queue[0]
	//		queue = queue[1:]
	//		for j := i + 1; j < len(nums); j++ {
	//			if nums[j]-nums[i] <= target && nums[j]-nums[i] >= -target {
	//				//如果已经到了，下一轮就不用跑了，直接将结果替换到res上即可
	//				//比如1, 3, 6, 4, 1, 2， 第一轮可以直接到2，则res=2
	//				if j == len(nums)-1 {
	//					if t > res {
	//						res = t
	//					}
	//				}
	//				queue = append(queue, j)
	//			}
	//		}
	//	}
	//}
	//return res

	//dp[i]表示以i结尾的最大的跳跃次数
	dp := make([]int, len(nums))
	for i := 0; i < len(dp); i++ {
		dp[i] = -1
	}
	dp[0] = 0
	for i := 0; i < len(dp); i++ {
		if dp[i] == -1 {
			continue
		}
		for j := i + 1; j < len(nums); j++ {
			if nums[j]-nums[i] <= target && nums[j]-nums[i] >= -target {
				if dp[i]+1 > dp[j] {
					dp[j] = dp[i] + 1
				}
			}
		}
	}
	return dp[len(nums)-1]
}

func T35302() {
	nums := []int{1, 3, 6, 4, 1, 2}
	target := 0
	//target := 2
	//target := 3
	//nums := []int{1, 0, 2}
	//nums := []int{1151004, -368271873, -959137308, -363298760, 860913529,
	//	875734893, 653205161, -726919163, -107413863, -142574923, 535616977, -527647589,
	//	-933518315, 622674836, -626420393, 718010621, 443503514, 324638485, 303398068, 404393712,
	//	-682845482, 957378126, 254180033, 527664388, 204099822, 59043697, 284163204, -18806397,
	//	54466771, 218940186, 122932328, -527134788, 748489009, 481143527, -91930114, 650935932,
	//	49918996, 838929409, 298033606, 135544915, -231923297, -564040431, -403686128, -779212295}
	//target := 1152175137
	fmt.Println(maximumJumps(nums, target))
}
