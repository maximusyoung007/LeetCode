package solution

import (
	"sort"
	"strconv"
)

// 姓名和时间放到一个邻接表里，key是姓名，value是对应的时间
// 对每个姓名的时间排序，比较相隔两个的是否在一个小时内（左右指针）如果不满三个，直接排除
func AlertNames(keyName []string, keyTime []string) []string {
	m := make(map[string][]string)

	n := len(keyName)

	for i := 0; i < n; i++ {
		name := keyName[i]
		key := keyTime[i]
		_, ok := m[name]
		if ok {
			m[name] = append(m[name], key)
		} else {
			m[name] = []string{key}
		}
	}

	res := make([]string, 0)

	for k, v := range m {
		sort.Strings(v)
		if len(v) < 3 {
			continue
		}
		for i, j := 0, 2; j < len(v); i++ {
			if timeDiff(v[i], v[j]) <= 60 {
				res = append(res, k)
				j = len(v)
			}
			j++
		}
	}
	sort.Strings(res)
	return res
}

func timeDiff(t1 string, t2 string) int {
	h1, _ := strconv.Atoi(t1[0:2])
	m1, _ := strconv.Atoi(t1[3:5])
	h2, _ := strconv.Atoi(t2[0:2])
	m2, _ := strconv.Atoi(t2[3:5])
	return (h2*60 + m2) - (h1*60 + m1)
}
