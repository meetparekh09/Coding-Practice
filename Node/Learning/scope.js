(function foo(a) {
    var b = a * 2;
    var c = 3;

    function bar(c) {
        console.log(a, b, c);
    }

    bar(b * 3);
})(2);


{
    let a = 4;
    console.log(a);
}

// console.log(a); // Reference error
