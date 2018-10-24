function foo() {
    console.log(this);
    console.log(this.a);
}

var obj2 = {
    a: 42,
    foo: foo
};

var obj1 = {
    a: 2,
    foo: foo,
    obj2: obj2
};

obj1.foo();
obj1.obj2.foo();


var bar = obj1.foo;
global.a = "global a";

bar(); //implicit reference lost

//can really affect outcome of callback function

// setTimeout(obj1.foo, 500);
