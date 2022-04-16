// Primitives: number, string, boolean
// More complex types: arrays, objects
// Function types, parameters

// Primitives

// Declaration
// number
let age: number; // use lowercase number, uppercase Number points to Number object in JavaScript
// let age: number = 11;
age = 12; // integer
age = 13.3; // floating point number
// age = '13.4'; // error: TS2322: Type 'string' is not assignable to type 'number'.

// string
let userName: string;
userName = 'John';

// boolean
let isInstructor: boolean;
isInstructor = true;

// null - type
let nullValue: null;
// nullValue = 12; // TS2322: Type '12' is not assignable to type 'null'.

// More complex types: arrays, objects
// array of strings
let hobbies: string [];
hobbies = ['Sports', 'Cooking', 'Movies'];
// hobbies = [1, 2, 3]; // TS2322: Type 'number' is not assignable to type 'string'.
let numberArray: number [];
numberArray = [1, 2, 3];
let booleanArray: boolean [];
booleanArray = [true, false];

// type - any
let person; // S7043: Variable 'person' implicitly has an 'any' type, but a better type may be inferred from usage.
// let person: any;
person = {
    name: 'John',
    age: 32
}
person.name = 32;
person.age = 'John';

// object
let personObject: {
    name: string;
    age: number;
};

personObject = {
    name: "John",
    age: 33
}
printToConsole(personObject);
// personObject.name = 32; // TS2322: Type 'number' is not assignable to type 'string'.
// personObject.age = 'John'; // TS2322: Type 'string' is not assignable to type 'number'.

// array of persons
let persons: {
    name: string;
    age: number;
}[];

// Type inference - the best industry practise to use type inference, instead of explicitly stating type
let course = 'course name'; // inferred type string
// course = 12345; // TS2322: Type 'number' is not assignable to type 'string'.

// Type - union
let unionType: string | string [] | number | boolean = 'string value';
unionType = 12.3;
unionType = true;
unionType = ['one', 'two', 'three'];
// unionType = [1, 2, 3, 4]; // TS2322: Type 'number[]' is not assignable to type 'string | number | boolean'.

// type - keyword - type definition
type Employee = {
    name: string;
    age: number;
}

let employee: Employee = {
    name: 'John',
    age: 32
}

let employees: Employee[];
employees = [employee, {name: 'Jane', age: 32}];
printToConsole(employees)

// Functions & types
function add(a: number, b: number): number {
    return a + b;
}

// inferred return type string
function concat(a: string, b: string) {
    return a + b;
}

function unionAdd(a: string, b: string): string | number {
    return a + b;
}

function printToConsole(value: any): void {
    console.log(value);
}

// Generics
function insertAtBeginning(array: any[], value: any) {
    const newArray = [value, ...array];
    return newArray;
}

const numbers = [1, 2, 3, 4];
const updatedNumbers = insertAtBeginning(numbers, -1);
printToConsole(updatedNumbers);

// updatedNumbers[0].split('');

function insertAtBeginningGeneric<T>(array: T[], value: T) {
    const newArray = [value, ...array];
    return newArray;
}

const strings = ['one', 'two', 'three'];
// const updatedStrings = insertAtBeginningGeneric<string>(strings, 'zero');
const updatedStrings = insertAtBeginningGeneric(strings, 'zero');
printToConsole(updatedStrings)

// classes and interfaces
class Student {
    // by default all fields are public
    // firstName: string;
    // lastName: string;
    // age: number;
    // private courses: string [];
    //
    // constructor(firstName: string, lastName: string, age: number, courses: string []) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.age = age;
    //     this.courses = courses;
    // }

    // same as above, declaration in constructor - shorthand notation
    constructor(
        public fistName: string,
        public lastName: string,
        public age: number,
        private courses: string []
    ) {
    }

    enroll(courseName: string) {
        this.courses.push(courseName);
    }

    listCourses() {
        return this.courses.slice();
    }
}

const student = new Student('John', 'Doe', 35, ['Java', 'TypeScrip', 'Angular']);
printToConsole(student);
student.enroll('React');
printToConsole(student);
// student.courses; // TS2341: Property 'courses' is private and only accessible within class 'Student'.

// interfaces - will not be compiled to JavaScript
interface Human {
    name: string;
    age: number;

    greet: () => void;
}

let human: Human;

human = {
    name: 'John',
    age: 32,
    greet() {
        console.log('Hello! My name is ' + this.name + '. I\'m ' + this.age + ' years old. Nice to meet you!');
    }
}
human.greet();

class Instructor implements Human {
    age: number;
    name: string;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    greet(): void {
        console.log('Hello! My name is ' + this.name + '. I\'m ' + this.age + ' years old. Nice to meet you!');
    }
}

const instructor: Instructor = new Instructor('John Doe', 44);
printToConsole(instructor);
instructor.greet();






















