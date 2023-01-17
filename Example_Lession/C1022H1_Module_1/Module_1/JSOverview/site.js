function showPW() {
    if (document.getElementById('ckbPW').checked == true) {
        document.getElementsByName('pw')[0].type = 'text';
        // document.getElementsByName('pw')[0].style.color = 'red';
    }
    else {
        document.getElementsByName('pw')[0].type = 'password';
        // document.getElementsByName('pw')[0].style.color = 'black';
    }
}