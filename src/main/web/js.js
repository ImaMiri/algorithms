/**
 * Created by ima on 25/1/19.
 */

// Get the element, add a click listener...
document.getElementById("parent-list").addEventListener("click", function(e){
    // e.target is the clicked element!
    // If it was a list item
   if(e.target && e.target.nodeName == "LI"){
       // List item found!  Output the ID!
       console.log("List item", e.target.id.replace("post-",""),"was clicked!");

        // var foo = 10 + '20';
        // alert(foo);

       // var lion = new Animal("List item " + e.target.id.replace("post-","")+" was clicked!", false);
       // console.log(lion.toString());

       // let lion = new Animal("List item " + e.target.id.replace("post-","")+" was clicked!", false);
       // console.log(lion.fierce);
       // console.log(lion.toString());
   }
});

var mvar = function(){setInterval(timer,1000);}
function timer() {
    var d = new Date();
    document.getElementById("timer").innerHTML = d.toLocaleTimeString();
}

function submit(){
    setTimeout(function(){alert("Hi my friend");}, 10000);
    var x = 0.1;
    var y = 0.2;
    console.log(((0.1*10)+(0.2*10))/10==0.3);
    console.log(0.1+0.2==0.3);
    document.getElementById("output").innerHTML = "i'm a lasagna hog".split("").reverse().join("");
    var a = (window.foo || (window.foo = "bar"));
    console.log(a)

    var foo = "Hello";
    (function () {
        var bar = " World";
        alert(foo + bar);
    })();
    // alert(foo + bar);

    var boo = [];
    boo.push(1);
    boo.push(2);
    console.log(boo.length);

    var noo = {n:1};
    var mar = boo;
    noo.x=noo={n:2};
    console.log(noo.x);
    inter();
}

function inter(){
    setInterval(f, 50000);
}

function f(){
    console.log("test");
}
// ES5
// function Animal(name, fierce){
//     Object.defineProperty(this, 'name',{
//         get: function(){return name;}
//     });
//
//     Object.defineProperty(this, 'fierce',{
//        get: function () { return fierce;}
//     });
// }
//
// Animal.prototype.toString = function () {
//     return (this.fierce?'fierce':'tame') + ' ' + this.name;
// }


// ES6
class Animal{
    constructor(name, fierce){
        this._name = name;
        this._fierce = fierce;
    }

    get name(){
        return this._name;
    }

    get fierce(){
        return `This animal is ${this.fierce ? 'fierce':'tame'}`;
    }

    toString(){
        // return `This is a ${this._fierce?'fierce':'tame'} ${this._name}`;
        return `${this._name}`;
    }
}