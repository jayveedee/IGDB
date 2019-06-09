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

$("#profileBtn").onclick(function () {
   location.href = "User.html";
});
    
$.ajax({
    type : $(this).attr("method"),
    url : $(this).attr("action"),
    data : $(this).serialize(),
    success : function (data) {
        if (data == "null"){
            alert("Could not log in. Something is wrong with the password or the username");
        }else{
            localStorage.setItem("username", data);
            location.href = "Index.html";
        }
    },
    error : function () {
        alert("Couldn't log in, try again");
    }
});

