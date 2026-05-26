console.log("Hello from JS");


// JSON Array = JavaScript Object Notation
var users = [
    {"name" : "John", "gender" : "Male", "img" : "img/img_avatar3.png"},
    {"name" : "Jane", "gender" : "Female", "img" : "img/img_avatar2.png"}
];

var currentUserIndex = 0;

function toggleCard(){
    currentUserIndex = (currentUserIndex + 1) % users.length;
    var user = users[currentUserIndex];

    // DOM Manipulation
    var imgEl = document.getElementById("userImage");
    var genderEl = document.getElementById("userGender");
    var nameEl = document.getElementById("userName");
    if(imgEl) imgEl.src = user.img;
    if(genderEl) genderEl.textContent = user.gender;
    if(nameEl) nameEl.textContent = user.name;
}
