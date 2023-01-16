




class Remote {
    constructor(id, tv){
        this.id = id;
        this.tv = tv;
    }

    changeChannel(channel_change){
        this.tv.channel = channel_change;
    }

    changeVolume(up, down, volume_change){
        this.tv.vlomue = volume_change + up - down;
    }

    turnOn(){
        this.tv.status = "on"
    }

    turnOff(){
        this.tv.status = "off"
    }
}

class Tivi {
    constructor(channel, volume, status){
        this.channel = channel;
        this.volume = volume;
        this.status = status;
    }

    changeChannel(channel_change){
        return this.channel = channel_change;
    }

    changeVolume(up, down){
        return this.volume += up - down;
    }
}

//Khai báo và khởi tạo một chiếc TV và remote
let myTivi = new Tivi(1, 30, "off")
let myRemote = new Remote(1, myTivi)
console.log(`1___${myTivi.channel}`);

//Bật tv
myTivi.status = "on";

//Chuyển đến kênh 7
myTivi.changeChannel(7)
console.log(`2___${myTivi.channel}`);// 7

//Dùng remote chuyển đến kênh 3
myRemote.changeChannel(3)
console.log(`3___${myTivi.channel}`);// 3

//Tăng âm lượng lên 2 đơn vị
myTivi.changeVolume(2, 0, myTivi.volume)
console.log(`4___volume: ${myTivi.volume}`); // 32

//Dùng remote tắt tv
myRemote.turnOff()
console.log(`5___status: ${myTivi.status}`); // off