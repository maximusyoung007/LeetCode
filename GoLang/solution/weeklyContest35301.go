package solution

import "fmt"

func theMaximumAchievableX(num int, t int) int {
	t1 := num - 2*t
	t2 := num + 2*t

	if t1 >= t2 {
		return t1
	}
	return t2
}

func Test35301() {
	fmt.Println(theMaximumAchievableX(3, 2))
}
