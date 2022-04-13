// alert('Hello World');
console.log('Hello World!');

let numb = 23;
var second = 5;
const SOME_CONST = 12345;
let bool = true;
let fl = 15.5;

numb = true;
let a = '1';
let b = 1;
console.log("a + b = " + (a + b));
console.log("b + a = " + (b + a));
console.log(numb);

// let getName = prompt("Enter your name: ")
// console.log("Your name is " + getName)

let num = 10;
let num2 = 20;

document.write("Rezult: ", num + num2);
document.write('<br>');
document.write("Rezult: ", num * num2, '<br>');
document.write("Rezult: ", num / num2, '<br>');
num2 += 15;
num2 = num2 + 15;
num2 --;
document.write("Rezult: ", num2 % num, '<br>');
document.write(Math.PI, '<br>');
document.write(Math.ceil(2.3), '<br>');
document.write(Math.floor(2.3), '<br>');

let colors = ['red', 'blue', 'green'];
console.log(colors);
console.log(colors[1]);
colors[3] = 1234;
console.log(colors);
colors.push(false);
console.log(colors);

let colors2 = new Array();
colors2 = ['lorem', 1, 1.3, true, new Array()];
console.log(colors2);
console.log(colors[100]);

for (let i = 0; i < colors2.length; i++){
    console.log(colors2[i]);
}

const NEW_MAP = new Map();
NEW_MAP.set(1, 'a');
NEW_MAP.set('2', false);
NEW_MAP.set(2.5, 1);
NEW_MAP.set(colors, 1.4);
NEW_MAP.set(true, colors2);

console.log(NEW_MAP);

let d = 200;
while (d > 10){
    console.log(d);
    d = d / 2;
}

function writeToHtml(word){
    document.write(word);
}

function sum(a , b) {
    return a + b;
}

writeToHtml("Hello World");
writeToHtml('<br>');
writeToHtml('<h1>JavaScript</h1>');
writeToHtml(sum(5, 10));

let person = {
    firstName: 'John',
    lastName: 'Doe',
    age: 45,
    children: ['Jane', 'Wane'],
    address: {
        street: 'Some street',
        city: 'Some city'
    },
    getName: function () {
        return 'Person name is ' + this.firstName;
    }
}

writeToHtml(person);
console.log(person);
console.log(person.getName());

// let apple = new Object();
let apple = {};
apple.color = 'red';
apple.shape = 'round';

apple.describe = function () {
    return 'Apple is ' + this.shape;
}

console.log(apple.describe());

function Fruit(color, shape){
    this.color = color;
    this.shape = shape;
}

let melon = new Fruit('yellow', 'round');
console.log(melon);
melon.weight = 10.0;
melon.fresh = false;
console.log(melon);

function changeColor(newColor, selector){
   let element = document.getElementById(selector);
   element.style.color = newColor;
}