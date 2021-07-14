package main

import "fmt"

/*
Hands-on exercise #1
1. Using the short declaration operator, ASSIGN these VALUES to VARIABLES with the IDENTIFIERS “x” and “y” and “z”
	a. 42
	b. “James Bond”
	c. true

2. Now print the values stored in those variables using
	a. a single print statement
	b. multiple print statements
*/

func main() {
	x := 42
	y := "James Bond"
	z := true

	fmt.Println(x)
	fmt.Println(y)
	fmt.Println(z)
	fmt.Println(x, y, z)
}

/*
Output:
42
James Bond
true
42 James Bond true
*/
