$(function () {
   $('#Registrer').on('click', function (e) {
       $('.Login-form').css('display', 'none');
       $('.Registrer-form').css('display', 'inline');
       e.preventDefault();
   });
});

$(function () {
    $('#Login').on('click', function (e) {
        $('.Login-form').css('display', 'inline');
        $('.Registrer-form').css('display', 'none');
        e.preventDefault();
    });
});

var username = document.forms["vfrom"]["username"];
var email = document.forms["vfrom"]["email"];
var password = document.forms["vfrom"]["password"];
var password_confirmation = document.forms["vfrom"]["password_confirmation"];

var name_error = document.getElementById("name_error");
var email_error = document.getElementById("email_error");
var password_error = document.getElementById("password_error");

username.addEventListener("blur", nameVerify, true);
email.addEventListener("blur", emailVerify, true);
password.addEventListener("blur", passwordVerify, true);

function Validate() {
    if (username.value == ""){
        username.style.border = "1px solid red";
        name_error.textContent = "Username is required";
        username.focus();
        return false;
    }
    if (email.value == ""){
        email.style.border = "1px solid red";
        email_error.textContent = "Email is required";
        email.focus();
        return false;
    }
    if (password.value == ""){
        password.style.border = "1px solid red";
        password_error.textContent = "Password is required";
        password.focus();
        return false;
    }
}

