package main

import "strconv"

func SummaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return []string{}
	}
	pr := make([]int, 0)
	res := make([]string, 0)
	for i := range nums {
		if len(pr) == 0 {
			pr = append(pr, nums[i])
		} else {
			if pr[len(pr)-1] == nums[i]-1 {
				pr = append(pr, nums[i])
			} else {
				if len(pr) == 1 {
					res = append(res, strconv.Itoa(pr[0]))
				} else {
					start := pr[0]
					end := pr[len(pr)-1]
					res = append(res, strconv.Itoa(start)+"->"+strconv.Itoa(end))
				}
				pr = make([]int, 0)
				pr = append(pr, nums[i])
			}
		}
	}

	//最后一个数
	if len(pr) == 1 {
		res = append(res, strconv.Itoa(pr[0]))
	} else {
		start := pr[0]
		end := pr[len(pr)-1]
		res = append(res, strconv.Itoa(start)+"->"+strconv.Itoa(end))
	}

	return res
}
