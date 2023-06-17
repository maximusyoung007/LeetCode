package solution

//CanMakePaliQueries m种字母出现奇数次，只修改其中m/2个字母，即判断m/2是否小于k
//利用前缀和求子串中每种字母的个数
//sum[i+1][j]表示从s[0]到s[i]中，字母表第j个小写字母出现的奇偶性
func CanMakePaliQueries(s string, queries [][]int) []bool {
	sum := make([][26]int, len(s)+1)
	for i := 0; i < len(s); i++ {
		sum[i+1] = sum[i]
		sum[i+1][s[i]-'a'] ^= 1
	}
	res := make([]bool, len(queries))
	for i, q := range queries {
		left, right, k := q[0], q[1], q[2]
		m := 0
		for c := 0; c < 26; c++ {
			//只有奇数减偶数，或者偶数减奇数，才能得到奇数。所以如果相减的结果不为
			//0（或者说相减的两个数不相等），就表示出现了奇数次
			//注意：此处sum表示出现的次数是奇数还是偶数，1或者0，而不是实际出现的次数
			if sum[right+1][c] != sum[left][c] {
				m += 1
			}
		}
		if m/2 <= k {
			res[i] = true
		} else {
			res[i] = false
		}
	}
	return res
}
