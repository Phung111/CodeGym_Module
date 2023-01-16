




class SwitchButton {
    constructor(){
        this.status = "off";
        this.lamp = ElectricLamp;
    }

    connectToLamp(lamp){
        this.lamp = lamp;
    }

    switchOff(){
        return this.lamp.status = "off";
    }

    switchOn(){
        return this.lamp.status = "on";
    }

}

class ElectricLamp {
    constructor(status){
         this.status = "off";
    }
}

let ALamp = new ElectricLamp()
let BSwitch = new SwitchButton()

BSwitch.connectToLamp(ALamp)

console.log(`1__${ALamp.status}`);



BSwitch.switchOn();
console.log(`2__${ALamp.status}`);// on
BSwitch.switchOff();
console.log(`3__${ALamp.status}`);// off