function foo(num) {
    console.log(num);

    this.count++;
    // foo.count++;
}

foo.count = 0;

for(var i = 0; i < 10; i++) {
    foo.call(foo, i);
}

console.log(foo.count);
