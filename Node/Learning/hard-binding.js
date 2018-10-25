function foo(something) {
    console.log(this.a, something);
}


var obj = {
    a: 3
};

function bind(fn, obj) {
    return function() {
        fn.call(obj, arguments);
    };
}

var bar = bind(foo, obj);

bar(3);
setTimeout(bar(5), 100);
