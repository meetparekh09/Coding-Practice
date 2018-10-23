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
