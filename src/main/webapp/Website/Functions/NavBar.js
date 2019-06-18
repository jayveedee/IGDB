$(document).ready(function () {
    var username = localStorage.getItem("username");
    if (username === null || username === "null"){
        $("#profileBtn").css('display', 'none');
        $("#createArticle").css('display', 'none');
        $("#userList").css('display', 'none');
        $("#changeLog").css('display', 'none');
        $("#searchBar").css('margin-left', '300px');
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
        }else if (username !== null || username === "null") {
            localStorage.setItem("username", "null");
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

//FIXME ikke færdig kodet
$("#searchBar").submit(function (event) {
    event.preventDefault();
    var gameName = $("#searchInput").val();

    $.ajax({
        type : "post",
        url : "/rest/services/game/getGameID/" + gameName,
        success : function (data) {
            localStorage.setItem("currentGameID",data);
            window.location.href = "articleview.html"
        },
        error : function () {
            alert("Couldn't search for game, ajax not successful, try again");
        }
    });
});