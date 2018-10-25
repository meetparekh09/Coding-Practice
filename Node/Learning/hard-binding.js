function foo(something) {
    console.log(this.a, something);
}


var obj = {
    a: 3
};

// function bind(fn, obj) {
//     return function() {
//         fn.apply(obj, arguments);
//     };
// }

var bar = foo.bind(obj);

bar(3);
setTimeout(bar(5), 100);
