$(document).ready(function () {
    var username = localStorage.getItem("username");
    if (username === null || username === "null"){
        $("#profileBtn").css('display', 'none');
        document.getElementById("loginRegisterButton").innerHTML = "Login/Registrer";
    }else if (username !== null || username === "null") {
        $("#profileBtn").html(username);
        $("#profileBtn").css('display', 'inline');
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

$(".userDirection").click(function (event) {
    event.preventDefault();
    location.href = "User.html";
});

$(".articleDirection").click(function(event){
    event.preventDefault();
    location.href = "article.html";
});

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
            alert("hola");
            alert(data);
        },
        error : function () {
            alert("data was NOT sent and received successfully")
        }
    });
}
/*
            var options = " ";
            $.each(data, function (i, elt) {
                options +='<option value="'+elt.text+'">';
            });
            $('#dataList').html(options);
        },
        error : function () {
            alert("Something went wrong, try again");
        }
    });
}*/