$(document).ready(function () {
    $("#usernameInput").val(localStorage.getItem("username"));
    var username = localStorage.getItem("username");
    var action = "/rest/services/user/getUser/" + username;
    $.ajax({
        type : "post",
        url : action,
        success : function (data) {
            alert(data);
            /*
            var object = JSON.parse(data);
            var email = object.userEMAIL;
            var password = object.userPASS;

            $("#emailInput").val(email);
            $("#showAndHide").val(password);*/
        },
        error : function () {
            alert("Could not get user. Ajax call not successful");
        }
    });
});