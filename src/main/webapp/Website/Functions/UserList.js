var globalUserList;

$(document).ready(function loadUsers () {
    var action = "/rest/services/user/getUserList";

    $.ajax({
        type : "post",
        url : action,
        success : function (data) {
            var object = JSON.parse(data);
            var userList = object.userList;
            globalUserList = userList;

            var userListHTMLString = "";

            for (var i = 0; i < userList.length; i++) {
                userListHTMLString+= '<div class="UL"><div id="sul-1" class="sul-1"><input name="username" type="text" class="uos-1" id="UserNames" disabled="true" value="'+ userList[i].userNAME+'"><button type="button" class="euos-1" id="'+i+'">Remove user\'s permission to edit and create articles</button></div></div>';
                //alert(userList[i].userNAME);
            }
            $("#showUserList").html(userListHTMLString);
        },
        error : function () {
            alert("Could not get user. Ajax call not successful");
        }
    });
});

$(document).ready(function () {
    $(document).on('click',':button',function () {
        var index = $(this).attr("id");
        $.ajax({
            type: "post",
            url: "/rest/services/user/getUser/"+localStorage.getItem("username"),
            success : function (data) {
                var object = JSON.parse(data);
                var userRoles = object.userROLEs;
                var accessGranted = "false";
                //alert(JSON.stringify(object));
                for (var i = 0; i < userRoles.length; i++) {
                    if (userRoles[i].roleNAME === "Administrator" || userRoles[i].roleNAME === "Moderator"){
                        accessGranted = "true";
                    }
                }

                if (accessGranted === "true") {
                    if (window.confirm("are you sure that you want to remove this users Editor Role?")){
                        //var chosenIndex = $(this).attr("id");
                        var chosenUser = globalUserList[index];
                        //alert(JSON.stringify(chosenUser));
                        removeUserPermission(chosenUser);
                    }

                }else {
                    alert("you do not have the required permissions to do this");
                }
            },
            error : function () {
                alert("ajax call not successful")
            }
        });
    });
});

function removeUserPermission(object) {
    alert("this method is called");
    var Role ={
        roleID : 2,
        roleNAME : "User"
    };
    alert("so far so good");

    var userRoles = [];
    userRoles.push(Role);

    alert("hmmm");

    alert(JSON.stringify(object));
    var userDTO = {
        userNAME : object.userNAME,
        userPASS : object.userPASS,
        userEMAIL : object.userEMAIL,
        userGAMEs : object.userGAMEs,
        userROLEs : userRoles,
        userPFP : object.userPFP
    };

    alert("anyone there?");

    alert(JSON.stringify(userDTO));

    $.ajax({
        type : "post",
        url : "/rest/services/user/updateUserPermissions",
        data : JSON.stringify(userDTO),
        contentType : "application/json; charset=utf-8",
        success : function (data) {
            if (data === "true"){
                alert("The user's permission have been removed");
            } else {
                alert("The method returned false")
            }
        },
        error : function () {
            alert("ajax call not successful")
        }
    });


}
