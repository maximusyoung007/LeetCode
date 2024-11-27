package main

import "sort"

func ThreeSum(nums []int) [][]int {
	/**
	标签：数组遍历
	首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，
	数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
	如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
	如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
	当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
	当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−−

	*/
	sort.Ints(nums)

	res := make([][]int, 0)

	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			continue
		}

		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		left, right := i+1, len(nums)-1

		for left < right {
			sum := nums[left] + nums[right] + nums[i]
			if sum == 0 {
				if left+1 < right && nums[left] == nums[left+1] {
					left++
				} else if right-1 > left && nums[right] == nums[right-1] {
					right--
				} else {
					//排除了所有重复的
					res = append(res, []int{nums[i], nums[left], nums[right]})
					left++
					right--
				}
			} else if sum > 0 {
				right--
			} else if sum < 0 {
				left++
			}
		}
	}

	return res
}
