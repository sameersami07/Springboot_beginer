function display(user) {
    document.getElementById("userImage").src = user.pictureUrl;
    document.getElementById("userName").textContent = user.firstName + ' ' + user.lastName;
    document.getElementById("userGender").textContent = user.gender || 'Unknown';
}

function getAndDisplayRandomUser() {
    fetch('/api/users/random')
        .then(function(res) {
            return res.json();
        })
        .then(function(user) {
            display(user);
        })
        .catch(function(error) {
            console.error('Unable to fetch random user:', error);
        });
}