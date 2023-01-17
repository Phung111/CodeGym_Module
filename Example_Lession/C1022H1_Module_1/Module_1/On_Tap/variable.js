// var - pv global - tái sử dụng lại vùng nhớ
// let, const (ECMAScript 6 - ES 6 - 2015) - pv local/block code - tạo ra vùng nhớ mới
// scope (phạm vi)
//  global (toàn cục)
//  local (cục bộ)
//  block code (khối lệnh)

var number = 10;
console.log(number); //10
if(true)
{
    var number = 20; //hoisting
    console.log(number); //20
}
console.log(number); // 20 - 10

const pi = 10;