$(document).ready(function () {
    var gameID = parseInt(localStorage.getItem("currentGameID"));
    var action = "/rest/services/game/getGame/" + gameID;
    $.ajax({
        type : "post",
        url : action,
        success : function (data) {
            var gameDTO = JSON.parse(data);

            $("#coverImage").attr("src",gameDTO.gameCover);

            $("#backgroundImage").attr("style", "background-image:url("+ gameDTO.gameBG + ");");

            $("#title").text(gameDTO.gameNAME);

            $("#gamerelease").text(gameDTO.gameRELEASEDATE);

            $("#gamedev").text(gameDTO.gameDEV.devNAME);


            //initializing genre String
            var genreList = gameDTO.gameGENREs;
            var genreString = "";
            for (var i = 0; i < genreList.length; i++) {
                if (i !== 0){
                    genreString += ", " + genreList[i].genTITLE;
                } else {
                    genreString += genreList[i].genTITLE;
                }
            }
            $("#gameGenre").text(genreString);

            //initializing platform string
            var platformList = gameDTO.gamePLAT;
            var platString = "";
            for (var i = 0; i < platformList.length; i++) {
                if (i !== 0){
                    platString += ", " + platformList[i].platTITLE;
                } else {
                    platString += platformList[i].platTITLE;
                }
            }
            $("#gamePlatforms").text(platString);

            $("#gameDescription").text(gameDTO.gameBIO);

            //pictures
            var pictureList = gameDTO.gamePICs;
            var slideshowHTMLString = "";
            for (var i = 0; i < pictureList.length; i++) {
                slideshowHTMLString+="<img src='"+pictureList[i].picURL+"' class='slideImages'>";
            }
            $("#slideShow").html(slideshowHTMLString);

            //trailers
            var trailerList = gameDTO.gameTRAILERs;
            var trailerSlideshowHTMLString = "";
            for (var i = 0; i < trailerList.length; i++) {
                trailerSlideshowHTMLString+='<iframe class="slideVids" src="https://www.youtube.com/embed/'+trailerList[i].trailerURL+'"  frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>';
            }
            $("#trailerSlideShow").html(trailerSlideshowHTMLString);

            //characters
            var characterList = gameDTO.gameCHs;
            var characterHTMLString = "";
            for (var i = 0; i < characterList.length; i++) {
                characterHTMLString+= '<div class="info-list"><img class="infopic" src="'+ characterList[i].chPFP+'"><input class="dataoutput gamecharacter" type="text" readonly value="'+ characterList[i].chNAME+'"></div>'
            }
            $("#characterList").html(characterHTMLString);

            //Actors
            var actorList = gameDTO.gameACs;
            var actorHTMLString = "";
            for (var i = 0; i < actorList.length; i++) {
                actorHTMLString += '<div class="info-list"><img class="infopic" src="'+actorList[i].acPFP+'"><input class="dataoutput gameactor" type="text" readonly value="'+actorList[i].acFN+'"><input class="dataoutput gameactordate" type="text" readonly value="'+actorList[i].acBDAY+'"></div>'
            }
            $("#actorList").html(actorHTMLString);

            //Music Artist
            var musicArtistList = gameDTO.gameOST.ostMA;
            var musicArtistHTMLString = "";
            for (var i = 0; i < musicArtistList.length; i++) {
                musicArtistHTMLString+='<div class="info-list"><img class="infopic" src="'+musicArtistList[i].artPFP+'"><input class="dataoutput gameartist" type="text" readonly value="'+musicArtistList[i].artNAME+'"></div>'
            }
            $("#musicArtistList").html(musicArtistHTMLString);

            //Writers
            var writerList = gameDTO.gameWRI;
            var writerHTMLString = "";
            for (var i = 0; i <writerList.length ; i++) {
                writerHTMLString+='<div class="info-list"><input class="dataoutput gamewriter" type="text" readonly value="'+writerList[i].writerFN+'"></div>'
            }
            $("#writerList").html(writerHTMLString);

            //Composers
            var composerList = gameDTO.gameCOMP;
            var composerHTMLString = "";
            for (var i = 0; i < composerList.length; i++) {
                composerHTMLString+='<div class="info-list"><input class="dataoutput gamecomposer" type="text" readonly value="'+composerList[i].compFN+'"></div>'
            }
            $("#composerList").html(composerHTMLString);

            //Developer
            var developer = gameDTO.gameDEV;
            $("#developerName").attr("value",developer.devNAME);
            $("#developerOrigin").attr("value", developer.devCOUNTRY);
            $("#developerStatus").attr("value", developer.devSTATUS);
            $("#developerDate").attr("value", developer.devCREATED);

            //Publisher
            var publisher = gameDTO.gamePUB;
            $("#publisherName").attr("value", publisher.pubNAME);
            $("#publisherOrigin").attr("value", publisher.pubCOUNTRY);
            $("#publisherStatus").attr("value", publisher.pubSTATUS);
            $("#publisherDate").attr("value", publisher.pubCREATED);

            // Parent Company
            var company = gameDTO.gameDEV.devPCOMPANY;
            $("#companyName").attr("value", company.parentNAME);
            $("#companyOrigin").attr("value", company.parentCOUNTRY);
            $("#companyStatus").attr("value", company.parentSTATUS);
            $("#companyDate").attr("value", company.parentCREATED);
        },
        error : function () {
            alert("Could not get user. Ajax call not successful");
        }
    });
});

$("#editButton").click(function () {
    var permission = checkPermissions();
    if (permission === "Edit Games" || permission === "Delete and Edit Games" ) {
        window.location.href = "EditArticlePage.html";
    }else {
        alert("you do not have the permission to edit a game");
    }
});

$("#deleteButton").click(function () {
    var permission = checkPermissions();
    if (permission === "Delete and Edit Games") {
        if (window.confirm("are you sure you want to delete this game")){
            $.ajax({
                type : "post",
                url : "/rest/services/game/deleteGame/"+localStorage.getItem("currentGameID"),
                success : function (data) {
                    if (data === "true") {
                        alert("game deleted successfully");
                        window.location.href = "Index.html";
                    }else {
                        alert("Game was not deleted. Possibly due to server error");
                    }
                },
                error : function () {
                    alert("ajax call not successful");
                }
            })
        }
    }else {
        alert("you do not have the permission to delete the game");
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