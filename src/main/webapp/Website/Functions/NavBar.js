$(document).ready(function () {

    var username = localStorage.getItem("username");
    if (username === null || username === "null"){
        $("#profileBtn").css('display', 'none');
        $("#createArticle").css('display', 'none');
        $("#userList").css('display', 'none');
        $("#changeLog").css('display', 'none');
        $("#searchBar").css('margin-left', '246px');
        document.getElementById("loginRegisterButton").innerHTML = "Login/Registrer";
    }else if (username !== null || username === "null") {
        $("#profileBtn").html(username);
        $("#profileBtn").css('display', 'block');
        $("#createArticle").css('display', 'block');
        $("#userList").css('display', 'block');
        $("#changeLog").css('display', 'block');
        document.getElementById("loginRegisterButton").innerHTML = "Logout";
    }
});

$(document).ready(function () {
    $("#loginRegisterButton").click(function (event) {
        event.preventDefault();
        var username = localStorage.getItem("username");
        if (username === null || username === "null"){
            location.href = "Login_Signup.html"
        }else if (username !== null || username !== "null") {
            localStorage.setItem("username", "null");
            localStorage.setItem("currentUser", "null");
            location.href ="Index.html"
        }
    });
});

$("#searchInput").keyup(
function loadAddresses() {
    var action;
    if ($("#searchInput").val() === "") {
        action = "/rest/services/game/getGameNames/empty";

    } else {
        action = "/rest/services/game/getGameNames/" + $("#searchInput").val();
    }

    $.ajax({
        type: "post",
        url: action,
        success: function (data) {
            //alert(data);
            var object = JSON.parse(data);
            var list = object.gameNames;
            var options = "";
            for (var i = 0; i < list.length; i++) {
                //alert(list[i]);
                options+='<option value="'+list[i]+'">';
            }
            $('#dataList').html(options);
        },
        error : function () {
            alert("data was NOT sent and received successfully")
        }
    });
});

$("#searchBar").submit(function (event) {
    event.preventDefault();
    var gameName = $("#searchInput").val();

    $.ajax({
        type : "post",
        url : "/rest/services/game/getGameID/" + gameName,
        success : function (data) {
            if (data === "0"){
                alert("This game does not exist, please write the complete game name");
            }else {
                localStorage.setItem("currentGameID",data);
                window.location.href = "articleview.html";
            }
        },
        error : function () {
            alert("Couldn't search for game, ajax not successful, try again");
        }
    });
});

$("#createArticle").click(function (event) {
    event.preventDefault();
    var permission = checkPermissions();
    if (permission === "Edit Games" || permission === "Delete and Edit Games" ) {
        window.location.href = "createarticle.html";
    }else {
        alert("you do not have the permission to create a game");
    }
});

function checkPermissions(){
    var currentUser = JSON.parse(localStorage.getItem("currentUser"));
    if (currentUser === null || currentUser === "null"){
        return "noPermissions";
    }
    var roleList = currentUser.userROLEs;

    var permissionToDeleteGame = "false";
    var permissionToEditGame = "false";
    var permissions = "noPermissions";

    for (var i = 0; i < roleList.length; i++) {
        if (roleList[i].roleNAME === "Moderator" || roleList[i].roleNAME === "Administrator" || roleList[i].roleNAME === "Editor") {
            permissionToEditGame = "true";
        }

        if (roleList[i].roleNAME === "Moderator" || roleList[i].roleNAME === "Administrator") {
            permissionToDeleteGame = "true";
        }
    }

    if (permissionToDeleteGame === "true") {
        permissions = "Delete and Edit Games";
        return permissions;
    }else if (permissionToEditGame === "true"){
        permissions = "Edit Games";
        return permissions;
    }

    return permissions;
}