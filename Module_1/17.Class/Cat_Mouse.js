




class Rat{
    constructor(name, mass, speed, status){
        this.name = name;
        this.mass = mass;
        this.speed = speed;
        this.status = status;
        
    }

    sound(){
        
    }

    mouseAlive(ate){
        if (ate == false) {
            console.log("The rat is Alive");
        }
        
    }

    mouseDead(ate){
        if (ate == true) {
            console.log("chít chít");
            console.log("The rat is Dead");
        }
        
    }
}

class Cat extends Rat{
    constructor(name, mass, speed,maxspeed, status, ate){
        super(name, mass, speed, status);
        this.ate = ate;
        this.maxspeed = maxspeed;
        
    }

    sound(){
        console.log("meo meo");
    }

    catchRat(ratspeed){
        if (this.speed > ratspeed){
            console.log('Cat can go catch Rat now');
            return this.ate = true;
        } else {
            console.log('Cat cant catch Rat')
            return this.ate = false;
        }
    }

    eatRat(ratstatus){
        if (ratstatus == "alive") {
            if(this.ate == true) {
                console.log('Cat catch one')
                return this.mass++;
            }
        } else {
            console.log("Rat is not alive");
        }
        
    }
}

//Tạo 2 đối tượng chuột và mèo
let aRat = new Rat("Jerry", 1, 3, "alive")
let aCat = new Cat ("Tom", 5, 10, 20, "alive", true)
aCat.sound()
console.log("Cat show up");

//Hành vi bắt chuột
aCat.catchRat(aRat.speed);
aCat.eatRat(aRat.status);

//Hiển thị cân nặng của mèo
console.log(`Cat's mass ${aCat.mass}`);

//Khi chuột chết
aRat.sound()
aRat.mouseDead(aCat.ate)

//Khi chuột còn sống
aRat.mouseAlive(aCat.ate)

// //Tạo chuột mới
// let aRat2 = new Rat("Jerry", 1, 1, "alive");
// console.log("New mouse show up");
// aRat.sound()

