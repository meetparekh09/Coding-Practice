function foo(something) {
    this.a = something;
}

var obj1 = {
    foo: foo
};

var obj2 = {};

obj1.foo(2);
obj1.foo.call(obj2, 3);

console.log(obj1.a);
console.log(obj2.a);

var bar = new obj1.foo(4);

console.log(obj1.a);
console.log(bar.a);


var obj3 = {};
var b = foo.bind(obj3);

b(5);
console.log(obj3.a);

var c = new b(7);
console.log(obj3.a);
console.log(c.a);

var ø = Object.create(null); //safe object sort of demilitarized zone if we want to use apply for parameter spreading
