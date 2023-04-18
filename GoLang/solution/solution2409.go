package solution

import (
	"strconv"
)

func CountDaysTogether(arriveAlice string, leaveAlice string, arriveBob string, leaveBob string) int {
	aa := calDays(arriveAlice)
	la := calDays(leaveAlice)
	ab := calDays(arriveBob)
	lb := calDays(leaveBob)
	ml, mr := 0, 0
	if la < lb {
		ml = la
	} else {
		ml = lb
	}

	if aa > ab {
		mr = aa
	} else {
		mr = ab
	}

	if ml-mr+1 > 0 {
		return ml - mr + 1
	}
	return 0
}

func calDays(date string) int {
	days := 0
	months := []int{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	dateMonth, _ := strconv.Atoi(date[0:2])
	dateDays, _ := strconv.Atoi(date[3:])
	for i := 1; i < dateMonth; i++ {
		days += months[i]
	}
	days += dateDays
	return days
}
