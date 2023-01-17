// trong đối tượng
// thuộc tính (properties): ten_thuoc_tinh: gia_tri
// phương thức(methods): ten_phuong_thuc: hàm (function)
let phu = {
    name: "Phú",
    age: 18,
    gender: true,
    hobbies: ["Đọc sách", "Xem phim", "Đá bóng"],
    language: {
        name: "English",
        level: "B1"
    },
    greeting: function () {
        console.log(`hello, I'm ${this.name}, ${this.age} years old`);
    }
}

// có 2 cách để truy xuất thuộc tính của đối tượng
// cách 1
// console.log(phu["hobbies"]);

// cách 2
// console.log(phu.hobbies);

// phu.greeting()

let iphone14 = {
    name: "Apple iPhone 14",
    price: 30000000,
    memory: "64G",
    manufactory: "Thailand",
    color: "violet"
}

let products = [
    {
        name: "Apple iPhone 14",
        price: 30000000,
        memory: "64G",
        manufactory: "Thailand",
        color: "violet"
    },
    {
        name: "Apple iPhone 11 pro max",
        price: 12000000,
        memory: "64G",
        manufactory: "China",
        color: "gray"
    }
]


let students = [
    {
        id: 1,
        fullname: "Phụng",
        gender: true,
        dob: "10/10/2000",
        greeting: function(){
            return `hello, I'm ${this.gender ? 'Mr' : 'Ms'}. ${this.fullname}`
        }
    },
    {
        id: 2,
        fullname: "Thủy",
        gender: false,
        dob: "09/07/2000",
        greeting: function(){
            return `hello, I'm ${this.gender ? 'Mr' : 'Ms'}. ${this.fullname}`
        }
    },
    {
        id: 3,
        fullname: "Duy",
        gender: true,
        dob: "10/10/2000",
        greeting: function(){
            return `hello, I'm ${this.gender ? 'Mr' : 'Ms'}. ${this.fullname}`
        }
    }
]

for(let i = 0 ; i < students.length; i++){
    console.log(students[i].greeting());
}