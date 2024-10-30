package main

func IntToRoman(num int) string {
	res := ""
	if num >= 1000 {
		t := num / 1000
		for t > 0 {
			res = res + "M"
			t--
		}
		num = num % 1000
	}

	if num >= 900 {
		res = res + "CM"
		num = num - 900
	}

	if num >= 500 {
		res = res + "D"
		num = num % 500
	}

	if num >= 400 {
		res = res + "CD"
		num = num - 400
	}

	if num >= 100 {
		t := num / 100
		for t > 0 {
			res = res + "C"
			t--
		}
		num = num % 100
	}

	if num >= 90 {
		res = res + "XC"
		num -= 90
	}

	if num >= 50 {
		res = res + "L"
		num = num % 50
	}

	if num >= 40 {
		res = res + "XL"
		num -= 40
	}

	if num >= 10 {
		t := num / 10
		for t > 0 {
			res = res + "X"
			t--
		}
		num = num % 10
	}

	if num >= 9 {
		res = res + "IX"
		num -= 9
	}

	if num >= 5 {
		res = res + "V"
		num = num % 5
	}

	if num >= 4 {
		res = res + "IV"
		num -= 4
	}

	if num >= 1 {
		for num > 0 {
			res = res + "I"
			num--
		}
	}

	return res
}
