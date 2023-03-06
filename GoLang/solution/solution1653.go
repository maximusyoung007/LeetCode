package solution

/*
*
f[i]表示前i个字符要删除的最小个数 f[0]=0
第i+1个字符为'a' 可以去掉这个a(则要删除的字符串+1),也可以删除前面的b(b个），f[i+1]= min (f[i] + 1, b)
第i+1个字符为'b',不影响 f[i+1]=f[i]
*/
func MinimumDeletions(s string) int {
	res, b := 0, 0
	for i := 0; i < len(s); i++ {
		if s[i] == 'b' {
			b++
		} else if s[i] == 'a' {
			if res+1 < b {
				res = res + 1
			} else {
				res = b
			}
		}
	}
	return res
}
