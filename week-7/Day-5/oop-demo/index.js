let p1 = {
    FN: 'Bach',
    LN: 'Tran'
}

function Person(FN2, LN2) {
    this.FN = FN2;
    this.LN = LN2;

    //don't define functions inside of function constructors
    //waste of memory
    //this.greet = function() {}
}

Person.prototype.greet = function() {
    console.log(`${this.FN} ${this.LN} says hi!`);
}

let p2 = new Person('Jane', 'Doe');
console.log(p2);
p2.greet();

console.log(Person.prototype);

let p3 = {};
Person.call(p3, 'John', 'Doe');

p3.__proto__ = Person.prototype;
console.log(p3);
p3.greet();

let obj1 = {
    someFunc: function() {
        console.log('inside someFunc()');
    }
}

let obj2 = {};
obj2.__proto__ = obj1;
obj2.someFunc();

class Student {
    
}

const s1 = new Student('John', 'Doe', 18);
console.log(s1);

class Rectangle {
    constructor(w, h) {
        this._width = w;
        this._height = h;
    }

    get area() {
        return this._width * this._height;
    }

    get width() {
        console.log('width get');
        return this._width;
    }
    
    get height() {
        console.log('height get');
        return this._height;
    }

    set width(w) {
        console.log('width set');
        this._width = w;
    }

    set height(h) {
        console.log('height set');
        this._height = h;
    }
}

let rect1 = new Rectangle(10, 15);
console.log(rect1.area);

console.log(rect1.width);
console.log(rect1.height);