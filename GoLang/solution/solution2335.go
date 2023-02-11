package solution

import "sort"

/*
*
x+y < z,t=x+y-z
如果t是偶数，先把x和y匹配t/2次进行消化，操作后有x+y=z,结果为t/2+z
如果t是奇数，先把x和y匹配(t-1)/2次进行消化，操作后 有x+y-1=z,结果为(t-1)/2+z+1
*/
func FillCups(amount []int) int {
	sort.Ints(amount)

	if amount[0]+amount[1] < amount[2] {
		return amount[2]
	} else {
		t := amount[0] + amount[1] - amount[2]
		if t%2 == 0 {
			return t/2 + amount[2]
		} else {
			return (t-1)/2 + amount[2] + 1
		}
	}
}
