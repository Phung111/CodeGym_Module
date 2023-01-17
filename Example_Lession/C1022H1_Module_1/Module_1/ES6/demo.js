class Person{
    constructor(id, fullname, gender){
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
    }

    greeting(){
        return `I'm ${this.gender ? "Mr" : "Ms"}. ${this.fullname}`;
    }

    static slogen(){
        return 'Still breath, still alive';
    }
}

class Staff extends Person{
    constructor(id, fullname, gender, salary, email){
        super(id, fullname, gender);
        this.salary = salary;
        this.email = email;
    }

    // intro(){
    //     return `I'm ${this.gender ? "Mr" : "Ms"}. ${this.fullname}, my salary is ${this.salary}`;
    // }
    greeting(){
        // return `${super.greeting()}, my salary is ${this.salary}`;
        return `my salary is ${this.salary},\nmy email is ${this.email}`;
    }
}

let khoa = new Person("123123", "Khoa Nguyễn", true);
console.log(Person.slogen());
let phu = new Staff("123123", "Phú Nguyễn", true, 10000000, "phu@gmail.com");
// console.log(phu.greeting()); 
console.log(Staff.slogen());
// console.log(phu.intro());