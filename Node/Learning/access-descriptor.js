var myobject = {
    get a() {
        return 2;
    }
}


console.log(myobject.a);
myobject.a = 3;
console.log(myobject.a);

Object.defineProperty(myobject, "b", {
    get: function() {
        return this.a*2;
    },

    enumerable: true
});

console.log(myobject.b);


var anotherObject = {
    get a() {
        return this._a_;
    },

    set a(val) {
        this._a_ = val * 2;
    }
}

anotherObject.a = 3;
console.log(anotherObject.a);
