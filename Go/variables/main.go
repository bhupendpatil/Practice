package main

import "fmt"

var b = 32
var c int

var z string = "this is z"
var s = "this is s"

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

	// Type
	fmt.Printf("%T\n", a)
	fmt.Printf("%T\n", firstName)
	fmt.Printf("%T\n", s)
	fmt.Printf("%T\n", z)

}

// Output
// 42
// 99
// 199
// Bhupend Patil
// 22
// 32
// 0
