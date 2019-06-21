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
                if (userList[i].userNAME === localStorage.getItem("username")) {
                    userListHTMLString+= userListHTMLString+= '<div class="UL"><div id="sul-1" class="sul-1"><input name="username" type="text" class="uos-1" id="UserNames" disabled="true" value="'+ userList[i].userNAME+'"></div></div>';
                }else {
                    userListHTMLString+= '<div class="UL"><div id="sul-1" class="sul-1"><input name="username" type="text" class="uos-1" id="UserNames" disabled="true" value="'+ userList[i].userNAME+'"><button type="button" class="euos-1" id="'+i+'">Remove user\'s permission to edit and create articles</button><button type="button" class="promotoPermissions" id="'+i+'">promote user to moderator</button> </div></div>';
                }
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
        var text = $(this).text();
        $.ajax({
            type: "post",
            url: "/rest/services/user/getUser/"+localStorage.getItem("username"),
            success : function (data) {
                var object = JSON.parse(data);
                var userRoles = object.userROLEs;
                var accessGranted = "false";
                for (var i = 0; i < userRoles.length; i++) {
                    if (userRoles[i].roleNAME === "Administrator" || userRoles[i].roleNAME === "Moderator"){
                        accessGranted = "true";
                    }
                }

                if (accessGranted === "true") {
                    if (text === "promote user to moderator") {
                        if (window.confirm("are you sure that you want to promote this user to a moderator?")) {
                            var chosenUser = globalUserList[index];
                            promotoUserPermissions(chosenUser);
                        }
                    }else {
                        if (window.confirm("are you sure that you want to remove this users Editor Role?")){
                            var chosenUser = globalUserList[index];
                            removeUserPermission(chosenUser);
                        }
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
    var Role ={
        roleID : 2,
        roleNAME : "User"
    };

    var userRoles = [];
    userRoles.push(Role);

    var userDTO = {
        userNAME : object.userNAME,
        userPASS : object.userPASS,
        userEMAIL : object.userEMAIL,
        userGAMEs : object.userGAMEs,
        userROLEs : userRoles,
        userPFP : object.userPFP
    };

    $.ajax({
        type : "post",
        url : "/rest/services/user/removeUserPermissions",
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

function promotoUserPermissions(object) {
    var Role ={
        roleID : 2,
        roleNAME : "User"
    };

    var Role1 = {
        roleID : 1,
        roleNAME : "Editor"
    };

    var Role2 = {
        roleID : 3,
        roleNAME : "Moderator"
    };

    var userRoles = [];
    userRoles.push(Role);
    userRoles.push(Role1);
    userRoles.push(Role2);

    var userDTO = {
        userNAME : object.userNAME,
        userPASS : object.userPASS,
        userEMAIL : object.userEMAIL,
        userGAMEs : object.userGAMEs,
        userROLEs : userRoles,
        userPFP : object.userPFP
    };

    $.ajax({
        type : "post",
        url : "/rest/services/user/promoteUserPermissions",
        data : JSON.stringify(userDTO),
        contentType : "application/json; charset=utf-8",
        success : function (data) {
            if (data === "true"){
                alert("The user has been promoted to a moderator");
            } else {
                alert("The method returned false")
            }
        },
        error : function () {
            alert("ajax call not successful")
        }
    });
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)