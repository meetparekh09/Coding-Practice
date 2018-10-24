function foo(num) {
    console.log(num);

    // this.count++; //refers to global object
    foo.count++;
}

foo.count = 0;

for(var i = 0; i < 10; i++) {
    foo(i);
}

console.log(foo.count);
