function Staff(id, name, gender, dob, salary, avatar) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.dob = dob;
    this.salary = salary;
    this.avatar = avatar;
}

let staffs = [
    new Staff(1, "Phụng", true, "01/01/2000", 10000000, "https://i.pravatar.cc/150?img=2"),
    new Staff(2, "Thủy", false, "11/07/2000", 11000000, "https://i.pravatar.cc/150?img=1"),
    new Staff(3, "Duy", true, "21/08/2000", 10500000, "https://i.pravatar.cc/150?img=2"),
    new Staff(4, "Phú", true, "15/06/2000", 10700000, "https://i.pravatar.cc/150?img=4"),
]

function displayStaff() {
    let tbStaff = "";
    // for (let i = 0; i < staffs.length; i++) {
    //     tbStaff += `
    //         <tr>
    //             <td>${staffs[i].id}</td>
    //             <td>${staffs[i].name}</td>
    //             <td>
    //                 <img class='avatar' src="${staffs[i].avatar}" />
    //             </td>
    //             <td>
    //                 ${staffs[i].gender ? "Male" : "Female"}
    //             </td>
    //             <td>${staffs[i].dob}</td>
    //             <td>${formatCurrency(staffs[i].salary)}</td>
    //         </tr>
    //     `;
    // }
    for (let staff of staffs) {
        tbStaff += `
            <tr>
                <td>${staff.id}</td>
                <td>${staff.name}</td>
                <td>
                    <img class='avatar' src="${staff.avatar}" />
                </td>
                <td>
                    ${staff.gender ? "Male" : "Female"}
                </td>
                <td>${staff.dob}</td>
                <td>${formatCurrency(staff.salary)}</td>
            </tr>
        `;
    }
    
    // staffs.forEach(function (staff, index) {
    //     tbStaff += `
    //                 <tr>
    //                     <td>${staff.id}</td>
    //                     <td>${staff.name}</td>
    //                     <td>
    //                         <img class='avatar' src="${staff.avatar}" />
    //                     </td>
    //                     <td>
    //                         ${staff.gender ? "Male" : "Female"}
    //                     </td>
    //                     <td>${staff.dob}</td>
    //                     <td>${formatCurrency(staff.salary)}</td>
    //                 </tr>
    //             `;
    // })
    document.querySelector('#tbStaff').innerHTML = tbStaff;
    
    // let htmls = staffs.map(function(staff, index){
    //     return `
    //             <tr>
    //                 <td>${staff.id}</td>
    //                 <td>${staff.name}</td>
    //                 <td>
    //                     <img class='avatar' src="${staff.avatar}" />
    //                 </td>
    //                 <td>
    //                     ${staff.gender ? "Male" : "Female"}
    //                 </td>
    //                 <td>${staff.dob}</td>
    //                 <td>${formatCurrency(staff.salary)}</td>
    //             </tr>
    //         `;
    // })
    // document.getElementById("tbStaff").innerHTML = htmls.join("");
}

function formatCurrency(number) {
    return number.toLocaleString('vi-VI', { style: 'currency', currency: 'VND' });
}


displayStaff();