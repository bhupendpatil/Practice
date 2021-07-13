package main

import "fmt"

var b = 32
var c int

var z string = "this is z"
var s = "this is s"

var d string

type hotdog int

var e hotdog

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

	// Zero value
	fmt.Println("Printing value of d", d, "ending")
	fmt.Printf("%T\n", d)

	d = "Dog"
	fmt.Println("This is", d)

	// fmt package
	fmt.Println(b)
	fmt.Printf("%T\n", b)
	fmt.Printf("%b\n", b)
	fmt.Printf("%x\n", b)
	b = 911
	fmt.Printf("%#x\n", b)
	fmt.Printf("%#x\t%b\t%x\n", b, b, b)

	s := fmt.Sprintf("%#x\t%b\t%x\n", b, b, b)
	fmt.Println(s)
	fmt.Printf("%v\n", b)

	// own type
	type fu int
	var ra fu
	fmt.Printf("%T\n", e)
	fmt.Printf("%T\n", ra)

	// conversion
	var q int
	q = int(ra)
	fmt.Println(q)
}

// Output
// 42
// 99
// 199
// Bhupend Patil
// 22
// 32
// 0
// int
// string
// string
// string
// Printing value of d  ending
// string
// This is Dog
// 32
// int
// 100000
// 20
// 0x38f
// 0x38f   1110001111      38f
// 0x38f   1110001111      38f

// 911
// main.hotdog
// main.fu
