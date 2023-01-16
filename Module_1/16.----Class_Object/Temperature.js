


//Khởi tạo lớp Temperature
let Temperature = function(temp){
    this.temp = temp;

    this.getF = function(){
        return 1.8*this.temp + 32
    }
    this.getK = function(){
        return this.temp + 273;
    }

    this.setTemp = function(temp){
        this.temp = temp
    }
}

//Khởi tạo một đối tượng Temperature.
let nhietdo = new Temperature(100)

//Gán giá trị độ C cho đối tượng ở nhiệt độ 25 độ.
nhietdo.setTemp(25)

//Hiển thị ra màn hình nhiệt độ F và độ Kenvin tương ứng.
var resultF = nhietdo.getF();
var resultK = nhietdo.getK();

console.log(resultF);
console.log(resultK);
