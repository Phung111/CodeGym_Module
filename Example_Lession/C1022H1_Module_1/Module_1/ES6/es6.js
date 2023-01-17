// function Student(id, fullname, age, gender, email){
//     this.id = id;
//     this.fullname = fullname;
//     this.age = age;
//     this.gender = gender;
//     this.email = email;

//     this.intro = function(){
//         return `I'm ${this.gender ? "Mr" : "Ms"}. ${this.fullname}`;
//     }
// }

// let thuy = new Student(1, "Thủy", 18, false, "thuy@gmail.com");

// console.log(thuy.intro());

class Student {
    constructor(id, fullname, age, gender, email) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    intro(){
        return `I'm ${this.gender ? "Mr" : "Ms"}. ${this.fullname}`;
    }
}


let thuy = new Student(1, "Thủy", 18, false, "thuy@gmail.com");

console.log(thuy.intro());