package solution

import (
	"fmt"
	"strconv"
)

func addStrings(num1 string, num2 string) string {
	var res string
	res = ""
	i, j := len(num1)-1, len(num2)-1
	r, index := 0, 0
	for i >= 0 && j >= 0 {
		n1, _ := strconv.Atoi(string(num1[i]))
		n2, _ := strconv.Atoi(string(num2[j]))
		r = n1 + n2 + index
		if r >= 10 {
			index = r / 10
			r = r % 10
		} else {
			index = 0
		}
		res = strconv.Itoa(r) + res
		i--
		j--
	}

	if i >= 0 {
		for i >= 0 {
			n1, _ := strconv.Atoi(string(num1[i]))
			r = n1 + index
			if r >= 10 {
				index = r / 10
				r %= 10
			} else {
				index = 0
			}
			res = strconv.Itoa(r) + res
			i--
		}
	}

	if j >= 0 {
		for j >= 0 {
			n2, _ := strconv.Atoi(string(num2[j]))
			r = n2 + index
			if r >= 10 {
				index = r / 10
				r %= 10
			} else {
				index = 0
			}
			res = strconv.Itoa(r) + res
			j--
		}
	}
	if index == 1 {
		res = strconv.Itoa(index) + res
	}
	return res
}

func Test415() {
	//num1, num2 := "11", "123"
	//num1, num2 := "456", "77"
	//num1, num2 := "0", "0"
	num1, num2 := "1", "9"
	fmt.Println(addStrings(num1, num2))
}
