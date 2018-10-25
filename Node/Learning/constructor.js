function foo() {
    this.a = 2;
}

var bar = new foo();
console.log(bar.a);
