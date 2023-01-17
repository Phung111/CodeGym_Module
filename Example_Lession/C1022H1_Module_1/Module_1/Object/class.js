// các đối tượng (object) có cùng thuộc tính và hành vi thì gom lại thành 1 class
// code convension (quy ước đặt tên), tên class theo quy ước là Pascal Case

// trong 1 class, có 3 thành phần
// contructor (phương thức khởi tạo)
// properties (fileds)
// methods (behaviours)
function Student(fullname, gender, dob, email){
    this.fullname = fullname,
    this.gender = gender,
    this.dob = dob,
    this.email = email,
    this.greeting = function(){
        return `hello, I'm ${this.gender ? 'Mr' : 'Ms'}. ${this.fullname}`
    }
    this.info = function(){
        return this;
    }
}

// let array = new Array()

// let thuy = new Student("Thủy", false, "01/07/2000", "thuy@gmail.com");
// let phung = new Student("Phụng", true, "11/10/2000", "phung@gmail.com");
// let phu = new Student("Phú", true, "01/01/2000", "phu@gmail.com");

// let students = [thuy, phung, phu];

let students = [
    new Student("Thủy", false, "01/07/2000", "thuy@gmail.com"),
    new Student("Phụng", true, "11/10/2000", "phung@gmail.com"),
    new Student("Phú", true, "01/01/2000", "phu@gmail.com")
]

for(let i = 0; i < students.length; i++){
    console.log(students[i].info());
}