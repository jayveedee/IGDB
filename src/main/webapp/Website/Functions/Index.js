$(document).ready(function () {
    var username = localStorage.getItem("username");
    if (username === null || username.length === 0){
        $("#profileBtn").hide();
        $("#loginRegisterButton").html("Login/Register");
    }else if (username !== null || username.length !== 0) {
        $("#profileBtn").show();
        $("#profileBtn").html(username);
        $("#loginRegisterButton").html("Log out");
    }
});

$("#loginRegisterButton").onclick(function (event) {
    event.preventDefault();
    var username = localStorage.getItem("username");
    if (username === null || username.length === 0){
        location.href = "Login_Signup.html"
    }else if (username !== null || username.length !== 0) {
        localStorage.setItem("username", null);
        location.reload();
    }
});

$("#profileBtn").onclick(function (event) {
    event.preventDefault();
    location.href = "User.html";
});

