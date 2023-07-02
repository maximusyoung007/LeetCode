package solution

import (
	"fmt"
	"sort"
)

func findPrimePairs(n int) [][]int {
	m := make(map[int]int, 0)
	res := make([][]int, 0)
	primes := isPrime35202(n)
	for i := 0; i < len(primes); i++ {
		if primes[i]+primes[i] == n {
			res = append(res, []int{primes[i], primes[i]})
		}
		_, ok := m[n-primes[i]]
		if ok {
			res = append(res, []int{n - primes[i], primes[i]})
		}
		m[primes[i]] = 1
	}
	sort.Slice(res, func(i, j int) bool {
		return res[i][0] < res[j][0]
	})
	return res
}

func isPrime35202(n int) []int {
	m := make([]int, n)
	p := make([]int, n)
	res := make([]int, 0)
	count := 0
	for i := 2; i <= n; i++ {
		if m[i-1] == 0 { // 如果未被筛过，则为素数
			p[count] = i
			count++
			res = append(res, i)
		}
		for j := 0; j < count; j++ {
			if i*p[j] > n {
				break
			}
			m[i*p[j]-1] = 1  // 将已经记录的素数的倍数进行标记
			if i%p[j] == 0 { //关键步骤
				break
			}
		}
	}
	return res
}

func Test035202() {
	//res := findPrimePairs(10)
	res := findPrimePairs(5)
	//res := findPrimePairs(2)
	fmt.Println(res)

	//fmt.Println(isPrime35202(10))
}
