console.log('Hello TypeScript')

let x: number = 10;
//x = '10';

let a: String;
a  = `2 + 2 is: ${2 + 2}`;
console.log(a);

let b = 'Another string';
//b = 123; // doesn't work b/c c is a string

let c; //c is of type 'any'
c = 'string';
c = 123;

let d: any = 100;
d = 'string12312312';
d = {firstname: 'Billy'}

let sentence = 'Hello World!';

console.log(sentence.charAt(2));

let notGuaranteedToBeAString: any = "Hi";

notGuaranteedToBeAString.charAt(5);

function namedFunction(a: string, b: number): void {
    console.log(`value of a is ${a}, and value of b is ${b}`);
}

let sub = function(a: number, b: number): number {
    return a - b;
}

let add = (a: number, b: number): number {
    return a + b;
}

let person = {
    'firstName': 'Bach',
    'lastName': 'Tran',
    'age': 24
};

let p2: { firstName: string, lastName: string, age: number};

interface Organism {
    age: number
}

interface Person extends Organism {
    firstName: string,
    lastName: string,
}

let p3: Person;

p3 = { 
    firstName: 'John',
    lastName: 'Doe',
    age: 20
}

let myPeople: Person[] = [];

myPeople.push(p3);
myPeople.push({firstName: 'testing', lastName: 'test', age: 30});

let myStrings: string[] = ['string1', 'string2', 'string3'];

class Animal {
    age: number;

    constructor(age: number) {
        this.age = age;
    }
}

class Dog extends Animal {
    private name: string;

    constructor(name: string, age: number) {
        super(age);
        this.name = name;
    }

    makeNoise() {
        console.log('Bark!');
    }

    getName() {
        return this.name;
    }
}

let d1: Dog = new Dog('Fido', 3);
d1.makeNoise();
console.log(d1.getName());

class Rectangle {

    constructor(public width: number, public height: number) {
    }
}

let r: Rectangle = new Rectangle(10, 20);
console.log(r);
console.log(r.width);
console.log(r.height);

class MyWrapper<T> {
    value: T;

    constructor(value: T) {
        this.value = value
    }
}

let wrapper11 = new MyWrapper<number>(100);
let wrapper2 = new MyWrapper<string>('a string');

function myFunc<T>(value: T): T[] {
    return [value];
}

let numbers: number[] = myFunc<number>(100);
numbers.push(200342);
console.log(numbers);

const MyDecorator = (target: any) => {
    console.log(target);
}

@MyDecorator
class Reimbursement {
    
}