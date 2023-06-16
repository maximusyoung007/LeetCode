package solution

import "fmt"

func nthUglyNumber(n int) int {
	res := make([]int, n)
	a, b, c, i := 0, 0, 0, 1
	res[0] = 1
	at, bt, ct, minT := 0, 0, 0, 0
	for i < n {
		at = res[a] * 2
		bt = res[b] * 3
		ct = res[c] * 5
		if at >= bt {
			minT = bt
		} else {
			minT = at
		}

		if ct < minT {
			minT = ct
		}

		if minT == at {
			a++
		}
		if minT == bt {
			b++
		}
		if minT == ct {
			c++
		}

		res[i] = minT
		i++

	}
	return res[n-1]
}

func Test0264() {
	fmt.Println(nthUglyNumber(10))
	fmt.Println(nthUglyNumber(1))
}
