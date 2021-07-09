package main

import "fmt"

var b = 32
var c int

func main() {
	// Short hand
	x := 42
	fmt.Println(x)
	x = 99
	fmt.Println(x)
	y := 100 + x
	fmt.Println(y)
	firstName := "Bhupend"
	lastName := "Patil"
	fmt.Println(firstName, lastName)

	// var keyword
	var a = 22
	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)

}

// Output
// 42
// 99
// 199
// Bhupend Patil
// 22
// 32
// 0
