import UIKit

// variable 
var a = "Bhupend";
var b = 1;

var firstName : String = "Bhupend";


// constant
let lastName : String = "Patil";



//boolean
var isTrue : Bool = true
var isFalse : Bool = false;

let constantBool : Bool = false;

isTrue = false;

var trueStatement : Bool = (5==5)

var falseStatement : Bool = (4==7)


//integers
var one = 1

var two : Int = 2

Int32(two)

two = 2

let tenn : Int = 10


var aa : Int = 5
var bb : Int = -15

aa + bb
aa - bb
aa * bb
bb / aa

Double(a)

var dd : Int = 0
let movement1 : Int = 6
let movement2 : Int = -8

dd = dd + movement1

dd

dd = dd + movement2


// float and double

var float1 : Float = 5.5
var float2 : Float = 5.55555555


var double1 : Double = 6.6
var double2 : Double = 6.6666666666666


var bank_balance : Float = 0;
let deposit : Float = 500.50
let withdrawal : Float = -223.98

var a = Float(bank_balance) + deposit + withdrawal


// characters and strings

var a : Character = "a"
var b : Character = "1"
var c : Character = "$"
var d : Character = "😂"

var string1 : String = "mammoth"
var string2 : String = " interactive"
var string3 : String = "" 

var string_to_int = Int("2")

var int_to_string = String(2)

print(int_to_string)



// optional variables (nil)

var someVariable : Int?

var newName : Int? = 56


// if statements

var question1 : Bool = true
let answer1 : Bool = true
var question2 : Bool = false
let answer2 : Bool = true
var score : Int = 0

if question1 == answer1 {
    score += 1
}

if question2 == answer2 {
    score += 1
}

print(score)


// if statements (nested, multi)

var isLoggedIn : Bool = false
var username : String = "bhupendpatil"
var password : String = "password"

if (username == "bhupend" && password == "password") {
    isLoggedIn = true
}

print(isLoggedIn)

isLoggedIn = false

if username == "bhupendpatil" {
    if password == "password" {
        isLoggedIn = true
    }
}

print(isLoggedIn)