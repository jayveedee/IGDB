$(document).ready(function () {
    var username = localStorage.getItem("username");
    if (username === null || username === "null"){
        $("#profileBtn").css('display', 'none');
        document.getElementById("loginRegisterButton").innerHTML = "Login/Registrer";
    }else if (username !== null || username === "null") {
        $("#profileBtn").html(username);
        $("#profileBtn").css('display', 'black');
        document.getElementById("loginRegisterButton").innerHTML = "Logout";
    }
});

$(document).ready(function () {
    $("#loginRegisterButton").click(function (event) {
        event.preventDefault();
        var username = localStorage.getItem("username");
        if (username === null || username === "null"){
            location.href = "Login_Signup.html"
        }else if (username !== null || username === "null") {
            localStorage.setItem("username", "null");
            location.reload();
        }
    });
});

$(".userDirection").click(function (event) {
    event.preventDefault();
    location.href = "User.html";
});

$(".articleDirection").click(function(event){
    event.preventDefault();
    location.href = "article.html";
});