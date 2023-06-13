package solution

func UnequalTriplets(nums []int) int {
	count := make(map[int]int)
	for _, v := range nums {
		count[v]++
	}
	res := 0
	pre, cur, n := 0, 0, len(nums)
	for _, cur = range count {
		c := n - pre - cur
		res += pre * cur * c
		pre += cur
	}
	return res
}
