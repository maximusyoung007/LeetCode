package solution

func SortColors(nums []int) {
	//分割线A左侧为0，分割线B右侧为2，A、B中间为1
	/*
		若遍历到的位置为0，则说明它一定位于A的左侧。于是就和A处的元素交换，同时向右移动A和C。
		2）若遍历到的位置为1，则说明它一定位于AB之间，满足规则，不需要动弹。只需向右移动C。
		3）若遍历到的位置为2，则说明它一定位于B的右侧。于是就和B处的元素交换，交换后只把B向左移动，C仍然指向原位置。（因为交换后的C可能是属于A之前的，所以C仍然指向原位置）
	*/
	lineA, lineB := 0, len(nums)-1
	index := 0

	for index <= lineB {
		if nums[index] == 0 {
			nums[index], nums[lineA] = nums[lineA], nums[index]
			lineA++
			index++
		} else if nums[index] == 1 {
			index++
		} else if nums[index] == 2 {
			nums[index], nums[lineB] = nums[lineB], nums[index]
			lineB--
		}
	}
}
