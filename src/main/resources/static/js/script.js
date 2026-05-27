var users = [
    {"name": "John Doe", "gender": "Male", "img": "img/john.png"},
    {"name": "Jane Doe", "gender": "Female", "img": "img/jane.png"}
];

var currentUserIndex = 0;

function toggleCard() {
    currentUserIndex = (currentUserIndex + 1) % users.length;
    var user = users[currentUserIndex];

    var imgEl = document.getElementById("userImage");
    var genderEl = document.getElementById("userGender");
    var nameEl = document.getElementById("userName");

    if (imgEl) imgEl.src = user.img;
    if (genderEl) genderEl.textContent = user.gender;
    if (nameEl) nameEl.textContent = user.name;
}
