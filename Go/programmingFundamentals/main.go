package main

import "fmt"

var x bool

func main() {
	// Bool type
	fmt.Println(x)
	x = true
	fmt.Println(x)

	a := 7
	b := 42
	fmt.Println(a == b)
	fmt.Println(a >= b)
	fmt.Println(a <= b)
	fmt.Println(a != b)
}
