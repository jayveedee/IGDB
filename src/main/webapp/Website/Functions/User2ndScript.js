$(document).ready(function () {
    $("#usernameInput").val(localStorage.getItem("username"));
    var username = localStorage.getItem("username");
    var action = "/rest/services/user/getUser/" + username;
    $.ajax({
        type : "post",
        url : action,
        success : function (data) {
            var object = JSON.parse(data);
            var email = object.userEMAIL;
            var password = object.userPASS;
            var roleList = object.userROLEs;
            var roleString = "";
            for (var i = 0; i < roleList.length; i++) {
                if (i === 0) {
                    roleString += roleList[i].roleNAME;
                }else {
                    roleString += ", " + roleList[i].roleNAME;
                }
            }
            $("#emailInput").val(email);
            $("#showAndHide").val(password);
            $("#userRoleInput").val(roleString);
        },
        error : function () {
            alert("Could not get user. Ajax call not successful");
        }
    });
});

$(document).ready(function () {
    $("#confirmPassword").css("display","none");
    $("#submitChanges").css("display", "none");
    $("#confirmPasswordText").css("display","none");
});

$("#changeUserInfoButton").click(function () {
    $("#confirmPassword").css("display","inline");
    $("#submitChanges").css("display", "inline");
    $("#confirmPasswordText").css("display","inline");
    $("#changeUserInfoButton").css("display", "none");
    $("#showAndHide").attr("disabled",false);
    $("#emailInput").attr("disabled",false);
    $("#confirmPassword").attr("disabled",false);
});

$("#userInfoForm").submit(function (event) {
    event.preventDefault();
    $("#confirmPassword").css("display","none");
    $("#submitChanges").css("display", "none");
    $("#changeUserInfoButton").css("display", "inline");
    if ($("#confirmPassword").val() !== $("#showAndHide").val()) {
        alert("Passwords do not match, try again");
        location.href = "User.html";
    }else {
        $("#usernameInput").attr("disabled", false);
        $.ajax({
            type : "post",
            url : "/rest/services/user/updateUser",
            data : $(this).serialize(),
            success : function (data) {
                $("#usernameInput").attr("disabled", true);
                if (data === "false"){
                    alert("There was properbly an SQL exception");
                }else if (data === "true") {
                    alert("user has been updated");
                    location.reload();
                }
            },
            error : function () {
                $("#usernameInput").attr("disabled", true);
                alert("Could not send and receive data successfully");
            }
        });
    }
});

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)