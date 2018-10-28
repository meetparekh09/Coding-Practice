function foo() {
    console.log(this.a);
}


var obj = {
    a: 2
};

// var bar = function() {
//     foo.apply(obj);
// }

var bar = foo.bind(obj);

// setTimeout(bar, 100);

bar();

function baz() {
    this.a = 2;
}

obj1 = {
    a: 3,
    baz: baz
};

obj2 = {
    a: 4
};

obj1.baz.apply(obj2);
console.log(obj1.a);
console.log(obj2.a);
