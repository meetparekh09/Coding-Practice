var myobject = {
    a: 2
};

console.log(Object.getOwnPropertyDescriptor(myobject, "a"));

myobject = {};

Object.defineProperty(myobject, "a", {
    value: 2,
    writable: true,
    configurable: true,
    enumerable: true
});

console.log(myobject.a);
myobject.a = 3;
console.log(myobject.a);


Object.defineProperty(myobject, "a", {
    value: 2,
    writable: false,
    configurable: true,
    enumerable: true
});

myobject.a = 5;
console.log(myobject.a);
