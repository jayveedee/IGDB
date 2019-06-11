$(document).ready(function () {
    var username = localStorage.getItem("username");
    if (username === null || username === "null"){
        $("#profileBtn").css('display', 'none');
        $("#createArticle").css('display', 'none');
        document.getElementById("loginRegisterButton").innerHTML = "Login/Registrer";
    }else if (username !== null || username === "null") {
        $("#profileBtn").html(username);
        $("#profileBtn").css('display', 'inline');
        $("#createArticle").css('display', 'inline');
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
            location.reload();
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
    location.href="createarticle.html";
    /*$.ajax({
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
    });*/
});