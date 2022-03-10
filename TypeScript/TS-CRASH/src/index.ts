// Basic Types
let id: number = 5
let company: string = "Blackmorph"
let isPublished: boolean = true
let x: any = "Hello"

let ids: number[] = [1, 2, 3, 4, 5]
let arr: any[] = [1, true, 'Bhupend']

// Tuple
let person: [number, string, boolean] = [1, 'Bhupend', true]
// Tuple Array
let employee: [number, string][]

employee = [
    [1, 'Bhupend'],
    [2, 'Harshad'],
    [3, 'Hitesh']
]

// Union
let pid: string | number = 22
pid = '22'

// Enum
enum Direction1 {
    Up = 'Up',
    Down = 'Down',
    Left = 'Left',
    Right = 'Right'
}

// Objects
type User = {
    id: number,
    name: string
}

const user: User = {
    id: 1, name: 'Bhupend'
}

// Type Assertion
let cid: any = 1
//let customerId = <number>cid
let customerId = cid as number

// Functions
function addNum(x: number, y: number): number {
    return x + y
}

function log(message: string | number): void {
    console.log(message)
}

// Interfaces
interface UserInterface {
    readonly id: number,
    name: string,
    age?: number
}

const user1: UserInterface = {
    id: 1, name: 'Bhupend'
}

interface MathFunc {
    (x: number, y: number): number
}

const add: MathFunc = (x: number, y: number): number => x + y
const sub: MathFunc = (x: number, y: number): number => x - y

interface PersonInterface {
    id: number,
    name: string,
    register(): string
}

// Classes
class Person implements PersonInterface {
    id: number
    name: string

    constructor(id: number, name: string) {
        this.id = id
        this.name = name
    }

    register() {
        return `${this.name} is now registered`
    }
}

const bhupend = new Person(1, 'Bhupend Patil')
const harshad = new Person(2, 'Harshad Patil')

// Subclasses
class Employee extends Person {
    position: string

    constructor(id: number, name: string, position: string) {
        super(id, name)
        this.position = position
    }
}

const emp = new Employee(1, 'Bhupend Patil','Developer')

// Generics
function getArray<T>(items: T[]): T[] {
    return new Array().concat(items)
}

let numArray = getArray<number>([1,2,3,4])
let strArray = getArray<string>(['Bhupend', 'Harshad', 'Hitesh'])

strArray.push('hello')
