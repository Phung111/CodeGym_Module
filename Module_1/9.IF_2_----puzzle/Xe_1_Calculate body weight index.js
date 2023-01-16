let cannang = 70;
let chieucao = 1.75;
let bmi = cannang / (chieucao * chieucao)
console.log(bmi)
if (bmi < 18)
    console.log('Hơi gầy');
else if (bmi < 25.0)
    console.log('Bình thường');
else if (bmi < 30.0)
    console.log('Mập');
else
    console.log('Quá mập');