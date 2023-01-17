const row = 10;
const col = 10;
const player_1 = 1;
const player_2 = 10;
const x_value = 1;
const o_value = 10;
var playing = player_1;

const caro = new Array(row);
for (let i = 0; i < row; i++) {
    let array = new Array(col);
    for (let j = 0; j < array.length; j++) {
        array[j] = 0;
    }
    caro[i] = array;
}

function renderCaroTable() {
    let tbCaro = "<table><tbody>";
    for (let i = 0; i < row; i++) {
        tbCaro += "<tr>";
        for (let j = 0; j < col; j++) {
            tbCaro += `<td onclick='play(${i}, ${j})' 
                        class='${caro[i][j] == 1 ? "x_cell" : caro[i][j] == 10 ? "o_cell" : 'empty_cell'}'>
                ${caro[i][j] == 1 ? "X" : caro[i][j] == 10 ? "O" : '&nbsp;&nbsp;'}</td>`;
        }

        tbCaro += "</tr>";
    }
    tbCaro += "</tbody></table>";


    document.getElementById('tbCaro').innerHTML = tbCaro;
}

function play(i, j) {
    if (caro[i][j] != 0) {
        alert("invalid position!");
        return;
    }
    if (playing == player_1) {
        caro[i][j] = x_value;
        playing = player_2;
    }
    else {
        caro[i][j] = o_value;
        playing = player_1;
    }
    renderCaroTable();
}

renderCaroTable();



function checkWin(type) {
    let array = [10, 0, 10, 0, 10, 10, 10];
    for (let i = 0; i < array.length - 2; i++) {
        if (array[i] == type && array[i + 1] == type && array[i + 2] == type) {
            return true;
        }
    }
    return false;
}