//Changes between Login and signup form
$(function () {
    $('#Registrer').on('click', function (e) {
        $('.Login-form').css('display', 'none');
        $('.Registrer-form').css('display', 'inline');
        $('.registrer-active').css('background', '#1E90FF');
        $('.login-active').css('background', 'none');
        e.preventDefault();
    });
 });
 
 $(function () {
     $('#Login').on('click', function (e) {
         $('.Login-form').css('display', 'inline');
         $('.Registrer-form').css('display', 'none');
         $('.login-active').css('background', '#1E90FF');
         $('.registrer-active').css('background', 'none');
         e.preventDefault();
     });
 });

 $(function () {
    $(".button").click(function () {
        var password = $("#pass_txt").val();
        var confirmPassword = $("#confirm_txt").val();
        if (password != confirmPassword) {
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
});
