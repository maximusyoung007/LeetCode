package solution

import (
	"strconv"
	"strings"
	"unicode"
)

func Evaluate(expression string) int {
	m := make(map[string]int)
	return eval(expression, m)
}

func eval(exp string, parent map[string]int) int {
	if exp[0] != '(' {
		if unicode.IsDigit(rune(exp[0])) || exp[0] == '-' {
			res, _ := strconv.Atoi(exp)
			return res
		}
		return parent[exp]
	}
	m := make(map[string]int)
	for k, v := range parent {
		m[k] = v
	}

	var sub string
	if exp[1] == 'm' {
		sub = exp[6 : len(exp)-1]
	} else {
		sub = exp[5 : len(exp)-1]
	}
	tokens := split(sub)
	if exp[0:2] == "(a" {
		return eval(tokens[0], m) + eval(tokens[1], m)
	} else if exp[0:2] == "(m" {
		return eval(tokens[0], m) * eval(tokens[1], m)
	} else {
		for i := 0; i < len(tokens)-2; i += 2 {
			m[tokens[i]] = eval(tokens[i+1], m)
		}
		return eval(tokens[len(tokens)-1], m)
	}
}

func split(str string) []string {
	var res []string
	par := 0
	var build strings.Builder
	for _, v := range str {
		if v == '(' {
			par++
		}
		if v == ')' {
			par--
		}
		if par == 0 && v == ' ' {
			res = append(res, build.String())
			build.Reset()
		} else {
			build.WriteRune(v)
		}
	}

	if build.Len() > 0 {
		res = append(res, build.String())
	}
	return res
}
