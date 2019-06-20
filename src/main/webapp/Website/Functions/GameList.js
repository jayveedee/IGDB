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