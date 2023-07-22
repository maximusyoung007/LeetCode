package solution

import "fmt"

func lemonadeChange(bills []int) bool {
	rest := make([]int, 3)
	for _, bill := range bills {
		if bill == 5 {
			rest[0] += 1
		} else if bill == 10 {
			if rest[0] >= 1 {
				//找一张五块的，收一张十块的
				rest[0] -= 1
				rest[1] += 1
			} else {
				return false
			}
		} else if bill == 20 {
			if rest[0] >= 1 && rest[1] >= 1 {
				//找一张五块，一张十块的，收一张二十的
				rest[0] -= 1
				rest[1] -= 1
				rest[2] += 1
			} else if rest[0] >= 3 {
				//找3张五块的，收一张二十的
				rest[0] -= 3
				rest[2] += 1
			} else {
				return false
			}
		}
	}
	return true
}

func Test0860() {
	bills := []int{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}
	fmt.Println(lemonadeChange(bills))
}
