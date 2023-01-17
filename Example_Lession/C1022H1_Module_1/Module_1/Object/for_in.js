let numbers = [1, 5, 4, 5, 5, 6, 8, 9, 9];
numbers.length = 12;
// for(let i = 0; i < numbers.length; i++){
//     console.log(numbers[i]);
// }

// for(let index in numbers){
//     // console.log(numbers[index]);
//     console.log(`${index} - ${numbers[index]}`);
// }


// for(let number of numbers){
//     console.log(number);
// }

// forEach

// numbers.forEach(function(value, index){
//     console.log(`${index} - ${value}`);
// })

numbers.map(function(number, index){
    console.log(number);
})