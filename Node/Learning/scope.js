(function foo(a) {
    var b = a * 2;
    var c = 3;

    function bar(str, c) {
        eval(str);
        console.log(a, b, c);
    }

    bar("var b = 2", b * 3);
})(2);
