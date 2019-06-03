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