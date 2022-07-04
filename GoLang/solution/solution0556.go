package solution

import (
	"math"
	"strconv"
	"strings"
)

func NextGreaterElement(n int) int {
	nums := []byte(strconv.Itoa(n))

	i := len(nums) - 2
	j := len(nums) - 1
	for ; j >= 0; j,i = j - 1, i - 1 {
		if j != 0 {
			if nums[i] < nums[j] {
				break
			}
		} else {
			return -1
		}
	}

	var k int
	for k = len(nums) - 1; k >= 0; k-- {
		if nums[i] < nums[k] {
			break
		}
	}

	nums[i], nums[k] = nums[k], nums[i]

	s := string(nums)
	s1 := s[0:j]
	s2 := s[j:]
	s2 = reverse(s2)
	res := s1 + s2
	num, _ := strconv.Atoi(res)
	if num > math.MaxInt32 {
		return -1
	}
	return num

}

func reverse(str string) string {
	var bytes []byte = []byte(str)
	var build strings.Builder
	for i := 0; i < len(bytes); i++ {
		i2 := bytes[len(bytes)-i-1]
		build.WriteString(string(i2))
	}
	return build.String()
}

