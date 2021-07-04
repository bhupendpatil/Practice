package main

import "fmt"

func main() {
	x := 42
	fmt.Println(x)
	x = 99
	fmt.Println(x)
	y := 100 + x
	fmt.Println(y)
	firstName := "Bhupend"
	lastName := "Patil"
	fmt.Println(firstName, lastName)
}

// Output
// 42
// 99
// 199
// Bhupend Patil
