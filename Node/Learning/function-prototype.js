function Foo() {
    console.log("creating empty foo");
}

Foo.prototype.a = 2;

console.log(Foo.prototype);


var b = new Foo();
console.log(b.a);

console.log(b.hasOwnProperty("a"));
