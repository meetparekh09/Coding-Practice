// "use strict";
// function foo() {
//     var a = 2;
//
//     function bar() {
//         console.log(a);
//     }
//
//     bar(); //closure exists but not explicitly observed
// }
//
// foo();


function foo() {
    var a = 2;

    function bar() {
        console.log(a);
    }

    return bar;
}

var baz = foo();

baz(); //closure uncurtained



for(var i = 1; i <= 5; i++) {
    // let copy = i; // this works, but let's try IIFE
    (function() {
        var j = i; // now this is a copy of i in IIFE scope which will be closed in timer
        setTimeout(function timer() {
            console.log(j); // i won't work as it is still invoked from global scope
        }, j*1000);
    }());
}
