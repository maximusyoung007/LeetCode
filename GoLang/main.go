package main

import (
	"fmt"
	"gproject/solution"
)

func main() {

	var s string = solution.ToHex(26)
	fmt.Print(s + "\n");
	s = solution.ToHex(-1)
	fmt.Print(s)
}