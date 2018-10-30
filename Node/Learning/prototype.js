var myObject = {
    a:2
};

console.log(myObject.a);


var anotherObject = Object.create(myObject);

console.log(anotherObject.a);


console.log("\n\n");

for(var k in anotherObject) {
    console.log("found : " + k);
}

console.log(("a" in anotherObject));


console.log(anotherObject.hasOwnProperty("a"));
console.log(myObject.isPrototypeOf(anotherObject));


//Shadowing

anotherObject.a++;

console.log("\n\n");
console.log(myObject.a);
console.log(anotherObject.a);
