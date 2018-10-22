"use strict";

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


for(var i = 0; i < 3; i++) {
    console.log(i);
}

console.log(i); //not a reference error


for(let j = 0; j < 3; j++) {
    console.log(j);
}

// console.log(j); // Reference error
