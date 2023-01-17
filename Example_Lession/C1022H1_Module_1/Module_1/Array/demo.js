// let fruits = ["Banana", "Orange", "Apple", "Kiwi"];

// fruits.sort();
// console.log(fruits);

let ages = [10, 1, 2, 11, 21, 3, 12];

function compare(n1, n2){
    return n1 - n2;
}
ages.sort(compare); // [1, 2, 3, 10, 11, 12, 21]

console.log(ages);


function sum(n1, n2){
    // console.log(n1 + n2);
    return n1 + n2;
}

let total = sum(10, 20);
console.log(`Total: ${total}`);