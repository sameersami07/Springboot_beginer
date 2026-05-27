function display(user){
    document.getElementById("userImage").src = user.picture.large;
    document.getElementById("userName").textContent = user.name.first + ' ' + user.name.last;
    document.getElementById("userGender").textContent = user.gender;
}

function getAndDisplayRandomUser(){
    fetch('https://randomuser.me/api/')
        .then(function(res){
            return res.json();
        })
        .then(function(data){
            var  userData = data.results[0];
            display(userData);
        });
    }