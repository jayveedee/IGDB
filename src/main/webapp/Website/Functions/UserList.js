$(document).ready(function () {
    var action = "/rest/services/user/getUser/{username}";

    $.ajax({
        type : "post",
        url : action,
        success : function (data) {
            //alert("hej");
            var object = JSON.parse(data);
            var username = object.userNAME;

            $("#UserNames").val(username);
        },
        error : function () {
            alert("Could not get user. Ajax call not successful");
        }
    });
});