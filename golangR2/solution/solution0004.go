package solution

import "math"

func FindMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	//确保nums1比nums2短
	if len(nums1) > len(nums2) {
		tempNums := nums1
		nums1 = nums2
		nums2 = tempNums
	}

	m := len(nums1)
	n := len(nums2)

	totalLeft := m + (n-m+1)/2

	left, right := 0, m

	//在第一个数组nums1的区间[0,m]中查找恰当的分割线，满足nums1[i-1]<=nums2[j] && nums2[j-1]<=nums[i]
	//i-1表示在分割线左边
	for left < right {
		i := left + (right-left+1)/2
		j := totalLeft - i
		if nums1[i-1] > nums2[j] {
			right = i - 1
		} else {
			left = i
		}
	}

	i := left
	j := totalLeft - i
	var nums1LeftMax, nums1RightMin, nums2LeftMax, nums2RightMin int
	if i == 0 {
		nums1LeftMax = math.MinInt
	} else {
		nums1LeftMax = nums1[i-1]
	}

	if i == m {
		nums1RightMin = math.MaxInt
	} else {
		nums1RightMin = nums1[i]
	}

	if j == 0 {
		nums2LeftMax = math.MinInt
	} else {
		nums2LeftMax = nums2[j-1]
	}

	if j == n {
		nums2RightMin = math.MaxInt
	} else {
		nums2RightMin = nums2[j]
	}

	if (m+n)%2 == 1 {
		return math.Max(float64(nums1LeftMax), float64(nums2LeftMax))
	} else {
		return (math.Max(float64(nums1LeftMax), float64(nums2LeftMax)) + math.Min(float64(nums1RightMin), float64(nums2RightMin))) / 2
	}
}
