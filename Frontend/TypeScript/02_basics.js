// Primitives: number, string, boolean
// More complex types: arrays, objects
// Function types, parameters
var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
// Primitives
// Declaration
// number
var age; // use lowercase number, uppercase Number points to Number object in JavaScript
// let age: number = 11;
age = 12; // integer
age = 13.3; // floating point number
// age = '13.4'; // error: TS2322: Type 'string' is not assignable to type 'number'.
// string
var userName;
userName = 'John';
// boolean
var isInstructor;
isInstructor = true;
// null - type
var nullValue;
// nullValue = 12; // TS2322: Type '12' is not assignable to type 'null'.
// More complex types: arrays, objects
// array of strings
var hobbies;
hobbies = ['Sports', 'Cooking', 'Movies'];
// hobbies = [1, 2, 3]; // TS2322: Type 'number' is not assignable to type 'string'.
var numberArray;
numberArray = [1, 2, 3];
var booleanArray;
booleanArray = [true, false];
// type - any
var person; // S7043: Variable 'person' implicitly has an 'any' type, but a better type may be inferred from usage.
// let person: any;
person = {
    name: 'John',
    age: 32
};
person.name = 32;
person.age = 'John';
// object
var personObject;
personObject = {
    name: "John",
    age: 33
};
printToConsole(personObject);
// personObject.name = 32; // TS2322: Type 'number' is not assignable to type 'string'.
// personObject.age = 'John'; // TS2322: Type 'string' is not assignable to type 'number'.
// array of persons
var persons;
// Type inference - the best industry practise to use type inference, instead of explicitly stating type
var course = 'course name'; // inferred type string
// course = 12345; // TS2322: Type 'number' is not assignable to type 'string'.
// Type - union
var unionType = 'string value';
unionType = 12.3;
unionType = true;
unionType = ['one', 'two', 'three'];
var employee = {
    name: 'John',
    age: 32
};
var employees;
employees = [employee, { name: 'Jane', age: 32 }];
printToConsole(employees);
// Functions & types
function add(a, b) {
    return a + b;
}
// inferred return type string
function concat(a, b) {
    return a + b;
}
function unionAdd(a, b) {
    return a + b;
}
function printToConsole(value) {
    console.log(value);
}
// Generics
function insertAtBeginning(array, value) {
    var newArray = __spreadArray([value], array, true);
    return newArray;
}
var numbers = [1, 2, 3, 4];
var updatedNumbers = insertAtBeginning(numbers, -1);
printToConsole(updatedNumbers);
// updatedNumbers[0].split('');
function insertAtBeginningGeneric(array, value) {
    var newArray = __spreadArray([value], array, true);
    return newArray;
}
var strings = ['one', 'two', 'three'];
// const updatedStrings = insertAtBeginningGeneric<string>(strings, 'zero');
var updatedStrings = insertAtBeginningGeneric(strings, 'zero');
printToConsole(updatedStrings);
// classes and interfaces
var Student = /** @class */ (function () {
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
    function Student(fistName, lastName, age, courses) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }
    Student.prototype.enroll = function (courseName) {
        this.courses.push(courseName);
    };
    Student.prototype.listCourses = function () {
        return this.courses.slice();
    };
    return Student;
}());
var student = new Student('John', 'Doe', 35, ['Java', 'TypeScrip', 'Angular']);
printToConsole(student);
student.enroll('React');
printToConsole(student);
var human;
human = {
    name: 'John',
    age: 32,
    greet: function () {
        console.log('Hello! My name is ' + this.name + '. I\'m ' + this.age + ' years old. Nice to meet you!');
    }
};
human.greet();
var Instructor = /** @class */ (function () {
    function Instructor(name, age) {
        this.name = name;
        this.age = age;
    }
    Instructor.prototype.greet = function () {
        console.log('Hello! My name is ' + this.name + '. I\'m ' + this.age + ' years old. Nice to meet you!');
    };
    return Instructor;
}());
var instructor = new Instructor('John Doe', 44);
printToConsole(instructor);
instructor.greet();
