//Changes between Login and signup form
$(function () {
    $('#Registrer').on('click', function (e) {
        $('.Login-form').css('display', 'none');
        $('.Registrer-form').css('display', 'inline');
        $('.registrer-tab').css('background', '#1E90FF');
        $('.login-tab').css('background', 'none');
        e.preventDefault();
    });
 });
 
 $(function () {
     $('#Login').on('click', function (e) {
         $('.Login-form').css('display', 'inline');
         $('.Registrer-form').css('display', 'none');
         $('.login-tab').css('background', '#1E90FF');
         $('.registrer-tab').css('background', 'none');
         e.preventDefault();
     });
 });

 //This function is checking if the password and password-confirm is the same
 $(function () {
    $("#regi_submit").click(function () {
        var password = $("#pass_txt").val();
        var confirmPassword = $("#confirm_txt").val();
        if (password !== confirmPassword) {
            alert("Password is not the same");
            return false;
        }
        return true;
    });
});

$("#registerForm").submit(function (event) {
    event.preventDefault();
    $.ajax({
        type : $(this).attr("method"),
        url : $(this).attr("action"),
        data : $(this).serialize(),
        success : function (data) {
            if (data == "true"){
                alert("Your new account has been created successfully!");
                location.href = "Login_Signup.html"
            }else{
                alert("Couldn't create user. This username might be taken. Try again.")
            }
        },
        error : function () {
            alert("Couldn't create user, try again");
        }
    });
});

$("#loginForm").submit(function (event) {
    event.preventDefault();
    $.ajax({
        type : $(this).attr("method"),
        url : $(this).attr("action"),
        data : $(this).serialize(),
        success : function (data) {
            var userObject = JSON.parse(data);
            if (userObject.userNAME === "usernameDoesNotExist"){
                alert("Could not log in. This username does not exist");
            }else if(userObject.userNAME === "passwordIsWrong"){
                alert("Could not log in. Password is wrong")
            } else{
                localStorage.setItem("username", userObject.userNAME);
                localStorage.setItem("currentUser", JSON.stringify(userObject));
                location.href = "Index.html";
            }
        },
        error : function () {
            alert("Couldn't log in, try again");
        }
    });
});

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)