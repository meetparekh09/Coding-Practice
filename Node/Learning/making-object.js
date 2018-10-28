var obj1 = {
    a: 2
};

var obj2 = new Object();
obj2.a = 3;

console.log(obj1.a);
console.log(obj2.a);

var strPrimitive = "I am a string";
console.log(strPrimitive);
console.log(typeof(strPrimitive));
console.log(strPrimitive instanceof String);

var strObject = new String("I am a string");
console.log(strObject);
console.log(typeof(strObject));
console.log(strObject instanceof String);
