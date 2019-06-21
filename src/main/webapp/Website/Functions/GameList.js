var globalGameList;

$(document).ready(function () {
    $.ajax({
        type : "post",
        url : "/rest/services/game/getGameList",
        success : function (data) {
            var jsonObject = JSON.parse(data);
            var gameList = jsonObject.gameList;
            globalGameList = gameList;
            var htmlString = "";
            for (var i = 0; i < gameList.length; i++) {
              htmlString += '<div class="contentContainer" id="'+i+'"><img class="gameCoverImage" src="'+gameList[i].gameCover+'"><div class="gameListContent"><div class="gameListGameName">'+gameList[i].gameNAME+'</div><div class="gameListReleaseDate">'+gameList[i].gameRELEASEDATE+'</div><div class="gameListDevName">'+gameList[i].gameDEV.devNAME+'</div></div></div>';
            }
            $("#gameListForm").html(htmlString);
        },
        error : function () {
            alert("ajax call failed");
        }
    });
});

$(document).on("click", ".contentContainer", function () {
    var id = $(this).attr("id");
    localStorage.setItem("currentGameID",globalGameList[id].gameID);
    window.location.href = "articleview.html";
});

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)