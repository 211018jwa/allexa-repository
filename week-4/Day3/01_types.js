printVariable('SomeString');

function printVariable(input) {
    console.log(input);
}

var myVariable = function() {
    console.log('Hello!');
}

myVariable();

z =20;
console.log(z);

var z = 10;

// x = 12; //cannot do this b/c let and const are not hoisted
let x = 'some string';
x = 12;
console.log(x);

function myRegularFunction() {
    let g = 'my function scoped variable';

    if(true) {
        let y = 'my block scoped variable';
        console.log(y);
        console.log(g);
        console.log(x);

        var myVar = 'abc';
    }
}

var i = 100;

for(var i = 0; i < 10; i++) {
    console.log(i);
}

console.log('i: ' + i);

let j = 100;

for(let j = 0; j < 10; j++) {
    console.log(j);
}

console.log('j: ' + j);

const h = 10;

let myArrowFunction = (intput1, input2) => {
    console.log(i);
    console.log(j);
};

myArrowFunction('abc', 'def');

let person1 = {
    'firstName' : 'Bach',
    'lasName' : 'Tran',
    'greet' : function() {
        console.log(this.firstName + ' ' + this.lasName + ' says hi!')
    }
}

person1.greet();

let person2 = {
    'firstName' : 'Jane',
    'lastName' : 'Doe'
}

person2.borrowedFunction = person1.greet;
person2.borrowedFunction();

let person3 = {
    'firstName' : 'John',
    'lastName' : 'Doe',
    'greet' : () => {
        console.log(this.firstName + ' ' + this.lasName + ' says hi!');
    }
}

person3.greet();

console.log(this);

let person4 = {
    'firstName' : 'Billy',
    'lastName' : 'Joe',
    'greet' : function() {
        console.log(this);

        let myArrowFunction = () => {
            console.log(this);
        }
    }
}

person4.greet();

let f = 'abc';
let myString1 = `${f} is the value of f`
console.log('myString1: ' + myString1);

let myString2 = `${myFunction()} is the value of x`
console.log(myString2);

function myFunction() {
    return 'def';
}
