"use strict";
// Basic Types
let id = 5;
let company = "Blackmorph";
let isPublished = true;
let x = "Hello";
let ids = [1, 2, 3, 4, 5];
let arr = [1, true, 'Bhupend'];
// Tuple
let person = [1, 'Bhupend', true];
// Tuple Array
let employee;
employee = [
    [1, 'Bhupend'],
    [2, 'Harshad'],
    [3, 'Hitesh']
];
// Union
let pid = 22;
pid = '22';
// Enum
var Direction1;
(function (Direction1) {
    Direction1["Up"] = "Up";
    Direction1["Down"] = "Down";
    Direction1["Left"] = "Left";
    Direction1["Right"] = "Right";
})(Direction1 || (Direction1 = {}));
const user = {
    id: 1, name: 'Bhupend'
};
// Type Assertion
let cid = 1;
//let customerId = <number>cid
let customerId = cid;
// Functions
function addNum(x, y) {
    return x + y;
}
function log(message) {
    console.log(message);
}
const user1 = {
    id: 1, name: 'Bhupend'
};
const add = (x, y) => x + y;
const sub = (x, y) => x - y;
// Classes
class Person {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
    register() {
        return `${this.name} is now registered`;
    }
}
const bhupend = new Person(1, 'Bhupend Patil');
const harshad = new Person(2, 'Harshad Patil');
// Subclasses
class Employee extends Person {
    constructor(id, name, position) {
        super(id, name);
        this.position = position;
    }
}
const emp = new Employee(1, 'Bhupend Patil', 'Developer');
// Generics
function getArray(items) {
    return new Array().concat(items);
}
let numArray = getArray([1, 2, 3, 4]);
let strArray = getArray(['Bhupend', 'Harshad', 'Hitesh']);
strArray.push('hello');
