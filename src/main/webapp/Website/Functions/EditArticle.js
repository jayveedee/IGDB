var row11counter = 0;
var row9counter = 0;
var row8counter = 0;
var row7counter = 0;
var row6counter = 0;
var row5counter = 0;
var row3Counter = 0;
var row2Counter = 0;
var row1Counter = 0;
var globalGameObjekt;


function generateRandomID(){
    var randomNumber = Math.floor(Math.random()*2000000000);
    return randomNumber;
}

/*--------------------------------------------------------------------------bt1*/
$(document).on("click", ".btn-add-row", function(){
    row1Counter++;
    var rowName = $(".rowName").eq(0).clone().show();
    rowName.attr("id","rowName-"+row1Counter);
    $(".element-wrapper").append(rowName);

    var rowURL = $(".rowURL").eq(0).clone().show();
    rowURL.attr("id","rowURL-"+row1Counter);
    $(".element-wrapper").append(rowURL);

    var rowBirthDay = $(".rowBirthDay").eq(0).clone().show();
    rowBirthDay.attr("id","rowBirthDay-"+row1Counter);
    $(".element-wrapper").append(rowBirthDay);
});

function increaseRow1(){
    row1Counter++;
    var rowName = $(".rowName").eq(0).clone().show();
    rowName.attr("id","rowName-"+row1Counter);
    $(".element-wrapper").append(rowName);

    var rowURL = $(".rowURL").eq(0).clone().show();
    rowURL.attr("id","rowURL-"+row1Counter);
    $(".element-wrapper").append(rowURL);

    var rowBirthDay = $(".rowBirthDay").eq(0).clone().show();
    rowBirthDay.attr("id","rowBirthDay-"+row1Counter);
    $(".element-wrapper").append(rowBirthDay);
}

$(document).on("click", ".btn-remove-row", function(){
    if (row1Counter !== 0){
        $(".rowName").eq(row1Counter).remove();
        $(".rowURL").eq(row1Counter).remove();
        $(".rowBirthDay").eq(row1Counter).remove();
        row1Counter--;
    }
});

/*--------------------------------------------------------------------------bt2*/
$(document).on("click", ".btn-add-row2", function(){
    row2Counter++;
    var row2 = $(".row2").eq(0).clone().show();
    row2.attr("id","row2-"+row2Counter);
    $(".element-wrapper2").append(row2);
});

function increaseRow2(){
    row2Counter++;
    var row2 = $(".row2").eq(0).clone().show();
    row2.attr("id","row2-"+row2Counter);
    $(".element-wrapper2").append(row2);
}

$(document).on("click", ".btn-remove-row2", function(){
    if (row2Counter !== 0) {
        $(".row2").eq(row2Counter).remove();
        row2Counter--;
    }
});
/*--------------------------------------------------------------------------bt3*/
$(document).on("click", ".btn-add-row3", function(){
    row3Counter++;
    var row3 = $(".row3").eq(0).clone().show();
    row3.attr("id","row3-"+row3Counter);
    $(".element-wrapper3").append(row3);
});

function increaseRow3(){
    row3Counter++;
    var row3 = $(".row3").eq(0).clone().show();
    row3.attr("id","row3-"+row3Counter);
    $(".element-wrapper3").append(row3);
}

$(document).on("click", ".btn-remove-row3", function(){
    if (row3Counter !== 0) {
        var index3 = $(".btn-remove-row3").index(this);
        $(".row3").eq(row3Counter).remove();
        row3Counter--;
    }
});

/*--------------------------------------------------------------------------bt5*/
$(document).on("click", ".btn-add-row5", function(){
    row5counter++;
    var row5name = $(".row5name").eq(0).clone().show();
    row5name.attr("id","row5name-"+row5counter);
    $(".element-wrapper5").append(row5name);

    var row5URL = $(".row5URL").eq(0).clone().show();
    row5URL.attr("id","row5URL-"+row5counter);
    $(".element-wrapper5").append(row5URL);
});

function increaseRow5(){
    row5counter++;
    var row5name = $(".row5name").eq(0).clone().show();
    row5name.attr("id","row5name-"+row5counter);
    $(".element-wrapper5").append(row5name);

    var row5URL = $(".row5URL").eq(0).clone().show();
    row5URL.attr("id","row5URL-"+row5counter);
    $(".element-wrapper5").append(row5URL);
}

$(document).on("click", ".btn-remove-row5", function(){
    if (row5counter !== 0){
        $(".row5name").eq(row5counter).remove();

        $(".row5URL").eq(row5counter).remove();
        row5counter--;
    }
});
/*--------------------------------------------------------------------------bt6*/
$(document).on("click", ".btn-add-row6", function(){
    row6counter++;
    var row6 = $(".row6").eq(0).clone().show();
    row6.attr("id","row6-"+row6counter);
    $(".element-wrapper6").append(row6);
});

function increaseRow6(){
    row6counter++;
    var row6 = $(".row6").eq(0).clone().show();
    row6.attr("id","row6-"+row6counter);
    $(".element-wrapper6").append(row6);
}

$(document).on("click", ".btn-remove-row6", function(){
    if (row6counter !== 0) {
        $(".row6").eq(row6counter).remove();
        row6counter--;
    }
});
/*--------------------------------------------------------------------------bt7*/
$(document).on("click", ".btn-add-row7", function(){
    row7counter++;
    var row7 = $(".row7").eq(0).clone().show();
    row7.attr("id","row7-"+row7counter);
    $(".element-wrapper7").append(row7);
});

function increaseRow7(){
    row7counter++;
    var row7 = $(".row7").eq(0).clone().show();
    row7.attr("id","row7-"+row7counter);
    $(".element-wrapper7").append(row7);
}

$(document).on("click", ".btn-remove-row7", function(){
    if (row7counter !== 0) {
        $(".row7").eq(row7counter).remove();
        row7counter--;
    }
});
/*--------------------------------------------------------------------------bt8*/
$(document).on("click", ".btn-add-row8", function increaseRow8(){
    row8counter++;
    var row8 = $(".row8").eq(0).clone().show();
    row8.attr("id","row8-"+row8counter);
    $(".element-wrapper8").append(row8);
});

function increaseRow8(){
    row8counter++;
    var row8 = $(".row8").eq(0).clone().show();
    row8.attr("id","row8-"+row8counter);
    $(".element-wrapper8").append(row8);
}

$(document).on("click", ".btn-remove-row8", function(){
    if (row8counter !== 0){
        var index8 = $(".btn-remove-row8").index(this);
        $(".row8").eq(row8counter).remove();
        row8counter--;
    }
});
/*--------------------------------------------------------------------------bt9*/
$(document).on("click", ".btn-add-row9", function(){
    row9counter++;
    var row9 = $(".row9").eq(0).clone().show();
    row9.attr("id","row9-" + row9counter);
    $(".element-wrapper9").append(row9)
});

function increaseRow9(){
    row9counter++;
    var row9 = $(".row9").eq(0).clone().show();
    row9.attr("id","row9-" + row9counter);
    $(".element-wrapper9").append(row9)
}

$(document).on("click", ".btn-remove-row9", function() {
    if (row9counter !== 0) {
        $(".row9").eq(row9counter).remove();
        row9counter--;
    }
});
/*--------------------------------------------------------------------------bt10*/
//BLIVER DENNE HER IKKE BRUGT??? I SÅ FALD SKAL DEN SLETTES
$(document).on("click", "#btn10", function(){
    var row10 = $(".row10").eq(0).clone().show();
    $(".element-wrapper10").append(row10)
});

function increaseRow10(){
    var row10 = $(".row10").eq(0).clone().show();
    $(".element-wrapper10").append(row10)
}

$(document).on("click", ".btn-remove-row10", function() {
    var index10 = $(".btn-remove-row10").index(this);
    $(".row10").eq(index10).remove();
});
/*--------------------------------------------------------------------------bt11*/
$(document).on("click", "#btn11", function(){
    row11counter++;
    var row11Name = $(".row11Name").eq(0).clone().show();
    row11Name.attr("id","row11Name-"+row11counter);
    $(".element-wrapper11").append(row11Name);

    var row11URL = $(".row11URL").eq(0).clone().show();
    row11URL.attr("id","row11URL-"+row11counter);
    $(".element-wrapper11").append(row11URL);
});

function increaseRow11(){
    row11counter++;
    var row11Name = $(".row11Name").eq(0).clone().show();
    row11Name.attr("id","row11Name-"+row11counter);
    $(".element-wrapper11").append(row11Name);

    var row11URL = $(".row11URL").eq(0).clone().show();
    row11URL.attr("id","row11URL-"+row11counter);
    $(".element-wrapper11").append(row11URL);
}

$(document).on("click", ".btn-remove-row11", function() {
    if (row11counter !== 0) {
        $(".row11Name").eq(row11counter).remove();
        $(".row11URL").eq(row11counter).remove();
        row11counter--;
    }
});

$(document).ready(function () {
    var gameID = parseInt(localStorage.getItem("currentGameID"));
    var action = "/rest/services/game/getGame/" + gameID;
    $.ajax({
        type : "post",
        url : action,
        success : function (data) {
            var gameDTO = JSON.parse(data);
            globalGameObjekt = gameDTO;
            //handling all simpel data
            $("#titlefield").val(gameDTO.gameNAME);
            $("#releaseDateField").val(gameDTO.gameRELEASEDATE);
            $("#picturefield").val(gameDTO.gameCover);
            $("#backpicfield").val(gameDTO.gameBG);
            $("#soundtrackURLField").val(gameDTO.gameOST.ostURL);
            $("#soundtrackNameField").val(gameDTO.gameOST.ostTITLE);
            $("#row6-0").val(gameDTO.gameCOMP.compFN);
            $("#companyNameField").val(gameDTO.gameDEV.devPCOMPANY.parentNAME);
            $("#companyOriginField").val(gameDTO.gameDEV.devPCOMPANY.parentCOUNTRY);
            $("#companyStatusField").val(gameDTO.gameDEV.devPCOMPANY.parentSTATUS);
            $("#creationOfCompanyField").val(gameDTO.gameDEV.devPCOMPANY.parentCREATED);
            $("#developerNameField").val(gameDTO.gameDEV.devNAME);
            $("#developerCreationField").val(gameDTO.gameDEV.devCREATED);
            $("#developerOriginField").val(gameDTO.gameDEV.devCOUNTRY);
            $("#developerStatusField").val(gameDTO.gameDEV.devSTATUS);
            $("#publisherNameField").val(gameDTO.gamePUB.pubNAME);
            $("#publisherCreationField").val(gameDTO.gamePUB.pubCREATED);
            $("#publisherOriginField").val(gameDTO.gamePUB.pubCOUNTRY);
            $("#publisherStatusField").val(gameDTO.gamePUB.pubSTATUS);
            $("#gameDescfield").val(gameDTO.gameBIO);

            //game trailers
            var gameTrailerList = gameDTO.gameTRAILERs;
            for (var i = 0; i < gameTrailerList.length-1; i++) {
                increaseRow8();
            }
            for (var i = 0; i < gameTrailerList.length; i++) {
                $("#row8-"+i).val(gameTrailerList[i].trailerURL);
            }

            //Picture List
            var pictureList = gameDTO.gamePICs;
            for (var i = 0; i < pictureList.length-1; i++) {
                increaseRow9();
            }
            for (var i = 0; i < pictureList.length; i++) {
                $("#row9-" + i).val(pictureList[i].picURL);
            }

            //Music Artists
            var musicArtistList = gameDTO.gameOST.ostMA;
            for (var i = 0; i < musicArtistList.length - 1; i++) {
                increaseRow5();
            }

            for (var i = 0; i < musicArtistList.length; i++) {
                $("#row5name-"+i).val(musicArtistList[i].artNAME);
                $("#row5URL-"+i).val(musicArtistList[i].artPFP);
            }

            //Writers
            var writerList = gameDTO.gameWRI;
            for (var i = 0; i < writerList.length - 1; i++) {
                increaseRow7();
            }
            for (var i = 0; i < writerList.length; i++) {
                $("#row7-"+i).val(writerList[i].writerFN);
            }

            //Actors
            var actorList = gameDTO.gameACs;
            for (var i = 0; i < actorList.length - 1; i++) {
                increaseRow1();
            }
            for (var i = 0; i < actorList.length; i++) {
                $("#rowName-"+i).val(actorList[i].acFN);
                $("#rowURL-"+i).val(actorList[i].acPFP);
                $("#rowBirthDay-"+i).val(actorList[i].acBDAY);
            }

            //characters
            var characterList = gameDTO.gameCHs;
            for (var i = 0; i < characterList.length - 1; i++) {
                increaseRow11();
            }
            for (var i = 0; i < characterList.length; i++) {
                $("#row11Name-"+i).val(characterList[i].chNAME);
                $("#row11URL-"+i).val(characterList[i].chPFP);
            }

            //Platforms
            var platformList = gameDTO.gamePLAT;
            for (var i = 0; i < platformList.length - 1; i++) {
                increaseRow2();
            }
            for (var i = 0; i < platformList.length; i++) {
                $("#row2-"+i).val(platformList[i].platTITLE);
            }

            //genre
            var genreList = gameDTO.gameGENREs;
            for (var i = 0; i < genreList.length - 1; i++) {
                increaseRow3();
            }
            for (var i = 0; i < genreList.length; i++) {
                $("#row3-" + i).val(genreList[i].genTITLE);
            }

        },
        error : function () {
            alert("Could not get user. Ajax call not successful");
        }
    });
});

$("#updateGameForm").submit(function (event) {
    event.preventDefault();
    var id = globalGameObjekt.gameID;
    var GameDTO ={
        gameID : id,
        gameNAME : $("#titlefield").val(),
        gameCHs : getCharacterList(id),
        gameACs : getActors(id),
        gameGENREs : getGenres(id),
        gameGMs : null,
        gameRATINGs : null,
        gameRELEASEDATE : $("#releaseDateField").val(),
        gameWRI : getWriters(id),
        gameCOMP : getComposer(id),
        gameDEV : getDeveloper(id),
        gamePUB : getPublisher(id),
        gameOST : getSountrack(id),
        gamePLAT : getPlatforms(id),
        gameCover : $("#picturefield").val(),
        gameBG : $("#backpicfield").val(),
        gameBIO : $("#gameDescfield").val(),
        gameTRAILERs : getTrailers(id),
        gamePICs : getPictures(id)
    };

    $.ajax({
        type : "post",
        url : "/rest/services/game/updateGame",
        data : JSON.stringify(GameDTO),
        contentType : "application/json; charset=utf-8",
        success : function (data) {
            if (data === "true") {
                alert("Game updated successfully!");
                localStorage.setItem("currentGameID", GameDTO.gameID);
                window.location.href = "articleview.html";
            }else {
                alert("Something went wrong on the server side or you have chosen a game name that already exists");
            }
        },
        error : function () {
            alert("Could not update game. Ajax call not successful");
        }
    });

});

function getDeveloper(id) {

    var parentCompany = {
        parentID : generateRandomID(),
        parentNAME : $("#companyNameField").val(),
        parentCREATED : $("#creationOfCompanyField").val(),
        parentCOUNTRY : $("#companyOriginField").val(),
        parentSTATUS : $("#companyStatusField").val()
    };

    var developer = {
        devID : generateRandomID(),
        devNAME : $("#developerNameField").val(),
        devCREATED : $("#developerCreationField").val(),
        devSTATUS : $("#developerStatusField").val(),
        devCOUNTRY : $("#developerOriginField").val(),
        devPCOMPANY : parentCompany,
        devGAME : id
    };

    return developer;
}

function getPublisher(id) {
    var publisher = {
        pubID : generateRandomID(),
        pubNAME : $("#publisherNameField").val(),
        pubCREATED : $("#publisherCreationField").val(),
        pubCOUNTRY : $("#publisherOriginField").val(),
        pubSTATUS : $("#publisherStatusField").val(),
        pubGAME : id
    };
    return publisher;
}

function getComposer(id) {
    randomintlist = [1,2,3];
    var composer = {
        compID : generateRandomID(),
        compFN : $("#row6-0").val(),
        compLN : "placeholder",
        compOSTs : randomintlist,
        compGAME : id
    };
    return composer;
}

function getSountrack (id){
    var soundtrack = {
        ostID : generateRandomID(),
        ostTITLE : $("#soundtrackNameField").val(),
        ostCOMP : getComposer(id),
        ostMA : getMusicArtists(),
        ostGAME : id,
        ostURL : $("#soundtrackURLField").val()
    };
    return soundtrack;
}

function getCharacterList (id){
    var characterList = [];
    row11counter = 0;
    while ($("#row11Name-" + row11counter).val() !== undefined) {
        if ($("#row11Name-" + row11counter).val() === ""){
        }else {
            var character = {
                chID : generateRandomID(),
                chNAME :$("#row11Name-"+row11counter).val(),
                chPFP : $("#row11URL-"+row11counter).val(),
                chGAME : id
            };
            characterList.push(character);
        }
        row11counter++;
    }
    return characterList;
}

function getMusicArtists(){
    var musicArtistList = [];
    row5counter = 0;
    while ($("#row5name-" + row5counter).val() !== undefined) {
        if ($("#row5name-" + row5counter).val() === ""){
        }else {
            var musician = {
                artID : generateRandomID(),
                artNAME : $("#row5name-"+row5counter).val(),
                artPFP : $("#row5URL-"+row5counter).val()
            };
            musicArtistList.push(musician);
        }
        row5counter++;
    }
    return musicArtistList;
}

function getPlatforms(id){
    var platformList = [];
    row2Counter = 0;
    while ($("#row2-" + row2Counter).val() !== undefined) {
        if ($("#row2-" + row2Counter).val() === null){
        }else {
            var platform={
                platID : generateRandomID(),
                platTITLE : $("#row2-"+row2Counter).val(),
                platGAME : id,
                platCREATED : "hello"
            };
            platformList.push(platform);
        }
        row2Counter++;
    }
    return platformList;
}

function getTrailers(id){
    var trailerList = [];
    row8counter = 0;
    while ($("#row8-" + row8counter).val() !== undefined) {
        if ($("#row8-" + row8counter).val() === ""){
        }else {
            var trailer = {
                trailerID : generateRandomID(),
                trailerURL : $("#row8-"+row8counter).val(),
                trailerGameID : id
            };
            trailerList.push(trailer);
        }
        row8counter++;
    }
    return trailerList;
}

function getPictures(id){
    var pictureList = [];
    row9counter = 0;
    while ($("#row9-" + row9counter).val() !== undefined) {
        if ($("#row9-" + row9counter).val() === ""){
        }else {
            var picture = {
                picID : generateRandomID(),
                picURL : $("#row9-"+row9counter).val(),
                picGameID : id
            };
            pictureList.push(picture);
        }
        row9counter++;
    }
    return pictureList;
}

function getWriters(id){
    var writerList = [];
    row7counter = 0;
    while ($("#row7-" + row7counter).val() !== undefined) {
        if ($("#row7-" + row7counter).val() === ""){
        }else {
            var writer = {
                writerID : generateRandomID(),
                writerFN : $("#row7-"+row7counter).val(),
                writerLN : "placeholder",
                writerGAME : id
            };
            writerList.push(writer);
        }
        row7counter++;
    }
    return writerList;
}

function getActors(id){
    var randomIntegerList = [1,2,3];

    var actorList = [];
    row1Counter = 0;
    while ($("#rowName-" + row1Counter).val() !== undefined) {
        if ($("#rowName-" + row1Counter).val() === ""){
        }else {
            var actor = {
                acID : generateRandomID(),
                acFN : $("#rowName-"+row1Counter).val(),
                acLN : "placeholder",
                acBDAY : $("#rowBirthDay-"+row1Counter).val(),
                acCHs : randomIntegerList,
                acGAME : id,
                acPFP : $("#rowURL-"+row1Counter).val()
            };
            actorList.push(actor);
        }
        row1Counter++;
    }
    return actorList;
}

function getGenres(id){
    var genreList = [];
    row3Counter = 0;
    while ($("#row3-" + row3Counter).val() !== undefined) {
        if ($("#row3-" + row3Counter).val() === null){
        }else {
            var genre = {
                genID : generateRandomID(),
                genTITLE : $("#row3-"+row3Counter).val(),
                genGAME : id
            };
            genreList.push(genre);
        }
        row3Counter++;
    }
    return genreList;
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)