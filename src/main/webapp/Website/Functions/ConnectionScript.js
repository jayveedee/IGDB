$(document).ready(function () {
    $.ajax({
        type : "post",
        url : "/rest/services/createConnection",
        success : function (data) {
            if (data === "false") {
                alert("There was a SQLexception");
            }
        },
        error : function () {
            alert("Could not create a connection to the database!");
        }
    });
});

window.addEventListener("beforeunload", function () {
    $.ajax({
        type : "post",
        url : "/rest/services/closeConnection",
        success : function (data) {
            if (data === "false") {
                alert("There was a SQLexception");
            }
        },
        error : function () {
            alert("Could not create a connection to the database! 2222");
        }
    });
});