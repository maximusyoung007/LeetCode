package solution

/*
若区间[1,x-1]中的数字都被覆盖，且x在数组中，则[1,2x-1]内所有数字也被覆盖
若x缺失，则至少补充一个x,补充x后，则下一个缺失的数字不会小于2x
贪心方案：每次找到未被数组nums覆盖的最小整数x,填充x,然后寻找下一个未被覆盖的最小的整数，重复上述步骤直到区间[1,n]中所有的数字都被覆盖
x表示当前已经实现了[1, x-1]
前k个数字组成的范围是[1,total],添加第k+1个数nums[k]的时候，范围就变成了[1,total]&&[1+nums[k], total+nums[k]&&[nums[k],nums[k]]
可以合并为[1,total]&&[nums[k], nums[k]+total]
1、如果total>=nums[k]-1,可以构成[1, total+nums[k]]
2、如果total<nums[k]-1,需要添加一个total+1,构成更大的范围[1, total*2+1]
*/
func MinPatches(nums []int, n int) int {
	total, count, index := 0, 0, 0
	for total < n {
		if index < len(nums) && total >= nums[index]-1 {
			total = total + nums[index]
			index++
		} else {
			total = (total+1)*2 - 1
			count++
		}
	}
	return count
}
