console.log('Hello World');

var x = 'Hello World';
x = 10;
x = true;
x = null;
x = undefined;
x = {
        'firstname' : 'Bach',
        'lastName' : 'Tran'
    }

var someBool = true;
if(someBool) {
    console.log('someBool is true');
}
else {
    console.log('someBool is false');
}

var someNum = 10;
switch(someNum) {
    case 1:
        console.log('January');
        break;
    case 2: 
        console.log('Febuary');
        break;

    default:
        console.log('Not January or Febuary');
}

for(var i = 0; i < 100; i++) {
    console.log(i);
}

var counter = 0;
while (counter < 99) {
    console.log(counter);
    counter++;
}

var y = 123123;
do {
    console.log('inside do while block');
}while (y < 100);

var person1 = {
    'firstName' : 'John',
    'lastName' : 'Doe',
    'age' : 18
}

console.log(person1.firstName);
console.log(person1['firstName']);

var p = person1;
p.firstName = 'Jane';

console.log(person1.firstName);

var person2 = {
    'firstName' : 'Bach',
    'lastName' : 'Tran',
    'age' : 23
};

console.log(person2.firstName);

for(var i = 0; i < 5; i++) {
    var newProperty = prompt('Choose Property to add');
    var stringValue = prompt('Choose a value you want: ');
    person2[newProperty] = stringValue;
}

console.log(person2);

var person3 = {
    'firstName' : 'Micheal',
    'lastName' : 'liu',
    'greet' : function() {
        console.log(this.firstName + ' ' + this.lastName + ' says hi!');
    }
}

person3.greet();