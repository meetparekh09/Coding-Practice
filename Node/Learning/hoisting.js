console.log(a);

var a = 2;

// console.log(foo); //hoisted but type not specified if expression
//
// var foo = function bar() {
//     console.log('hello world');
// }

foo();

var foo; //ignored

function foo() {
    console.log(1);
}

function foo() {
    console.log(2);
}
