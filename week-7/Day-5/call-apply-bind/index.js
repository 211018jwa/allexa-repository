let p1 = {
    FN: 'Bach',
    LN: 'Tran',
    greet: function() {
        console.log(`${p1.FN} ${p1.LN} says hi!`)
    },
    printThis: function() {
        console.log(this);
    }

}

p1.greet();
p1.printThis();

let p2 = {
    FN: 'Jane',
    LN: 'Doe'
}

p2.b = p1.printThis;
p2.b();

p1.greet.call(p2);
p1.printThis.call(p2);

p1.greet.apply(p2,['!!!#$#']);

let greetBindedToP2 = p1.greet.bind(p2);

greetBindedToP2('!!!!!!');

function myFunc() {
    console.log(this);
}

let myBindedFunc = myFunc.bind(p2);

myFunc();
myBindedFunc();

let p3 = {
    FN: 'Test',
    LN: 'Test2',
    greet: fuction() {
        console.log(this);
        let myAFunc = () => {
            console.log(`${this.FN} ${this.LN} says hi!`);
        }
    }
}

p3.greet();
