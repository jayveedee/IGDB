//Changes between Login and signup form
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
 
 //Checks that all the fields are filed.
 var username = document.forms["vform"]["username"];
 var email = document.forms["vform"]["email"];
 var password = document.forms["vform"]["password"];
 var password_confirm = document.forms["vform"]["password_confirm"];
 
 var name_error = document.getElementById("name_error");
 var email_error = document.getElementById("email_error");
 var password_error = document.getElementById("password_error");
 
 username.addEventListener("blur", nameVerify, true);
 email.addEventListener("blur", emailVerify, true);
 password.addEventListener("blur", passwordVerify, true);
 
 function Validate() {
     if (username.value == ""){
         username.style.border = "1px solid red";
         document.getElementById('username_field').style.color = "red";
         name_error.textContent = "Username is required";
         username.focus();
         return false;
     }
     if (email.value == ""){
         email.style.border = "1px solid red";
         document.getElementById('email_field').style.color = "red";
         email_error.textContent = "Email is required";
         email.focus();
         return false;
     }
     if (password.value == ""){
         password.style.border = "1px solid red";
         document.getElementById('password_field').style.color = "red";
         password_confirm.style.border = "1px solid red";
         password_error.textContent = "Password is required";
         password.focus();
         return false;
     }
 
     if (password.value != password_confirm.value){
         password.style.border = "1px solid red";
         document.getElementById('password_checker').style.color="red";
         password.confirm.style.border = "1px solid red";
         password_error.innerHTML = "The two passwords do not match";
         return false;
     }
 }
 
 function nameVerify() {
     if (username.value != "") {
         username.style.border = "1px solid white";
         name_error.innerHTML = "";
         return true;
     }
 }
 
 function emailVerify() {
     if (email.value != "") {
         email.style.border = "1px solid white";
         email_error.innerHTML = "";
         return true;
     }
 }
 
 function passwordVerify() {
     if (password.value != "") {
         password.style.border = "1px solid white";
         document.getElementById('password_checker').style.color = "#5e6e66";
         document.getElementById('password_field').style.color = "#5e6e66";
         password_error.innerHTML = "";
         return true;
     }
     if (password.value === password_confirm.value){
         password.style.border = "1px solid #5e6e66";
         document.getElementById('password_checker').style.color = "#5e6e66";
         password_error.innerHTML = "";
         return true;
     }
 }