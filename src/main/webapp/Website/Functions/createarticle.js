var row11counter = 0;
var row9counter = 0;
var row8counter = 0;
var row7counter = 0;
var row6counter = 0;
var row5counter = 0;
var row3Counter = 0;
var row2Counter = 0;
var row1Counter = 0;

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

$(document).on("click", ".btn-remove-row7", function(){
    if (row7counter !== 0) {
        $(".row7").eq(row7counter).remove();
        row7counter--;
    }
});
/*--------------------------------------------------------------------------bt8*/
$(document).on("click", ".btn-add-row8", function(){
    row8counter++;
    var row8 = $(".row8").eq(0).clone().show();
    row8.attr("id","row8-"+row8counter);
    $(".element-wrapper8").append(row8);
});

$(document).on("click", ".btn-remove-row8", function(){
    var index8 = $(".btn-remove-row8").index(this);
    $(".row8").eq(row8counter).remove();
    if (row8counter !== 0){
        row8counter--;
    }
});
/*--------------------------------------------------------------------------bt9*/
$(document).on("click", ".btn-add-row9", function(){
    row9counter++;
    var row9 = $(".row9").eq(0).clone().show();
    row9.attr("id","row9-",row9counter);
    $(".element-wrapper9").append(row9)
});

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

$(document).on("click", ".btn-remove-row11", function() {
    if (row11counter !== 0) {
        $(".row11Name").eq(row11counter).remove();
        $(".row11URL").eq(row11counter).remove();
        row11counter--;
    }
});


$("#createGameForm").submit(function (event) {
    event.preventDefault();
    //initializing game and getting random id

    var id = generateRandomID();
    var game ={
        gameID : id,
        gameNAME : $("#titlefield").val(),
        gameCHs : getCharacterList(id),
        gameACs : [],
        gameGENREs : [],
        gameGMs : [],
        gameRATINGs : [],
        gameRELEASEDATE : $("#releaseDateField").val(),
        gameWRI : [],
        gameCOMP : null,
        gameDEV : null,
        gamePUB : null,
        gameOST : null,
        gamePLAT : [],
        gameCOVER : $("#picturefield").val(),
        gameBG : $("#backpicfield").val(),
        gameBIO : $("#gameDescfield").val(),
        gameTRAILERs : [],
        gamePICs : []
    };

    var parentCompany = {
        parentID : generateRandomID(),
        parentNAME : $("#companyNameField").val(),
        parentCREATED : $("#creationOfCompanyField").val(),
        parentCountry : $("#companyOriginField").val(),
        parentSTATUS : $("#companyStatusField").val()
    };

    var developer = {
        devID : generateRandomID(),
        devNAME : $("#developerNameField").val(),
        devCREATED : $("#developerCreationField").val(),
        devSTATUS : $("#developerStatusField").val(),
        devCOUNTRY : $("#developerOriginField").val(),
        devPCOMPANY : parentCompany,
        devGAME : game.gameID
    };

    var publisher = {
        pubID : generateRandomID(),
        pubNAME : $("#publisherNameField").val(),
        pubCREATED : $("#publisherCreationField").val(),
        pubCOUNTRY : $("#publisherOriginField").val(),
        pubSTATUS : $("#publisherStatusField").val(),
        pubGAME : game.gameID
    };

    var soundtrack = {
        ostID : generateRandomID(),
        ostTITLE : $("#soundtrackNameField").val(),
        ostCOMP : null,
        ostMA : null,
        ostGAME : game.gameID,
        ostURL : $("#soundtrackURLField").val()
    };

    var platform={
        platID : 0,
        platTITLE : "placeholder",
        platGAME : 0,
        platCREATED : "placeholder"
    };

    var trailer = {
        trailerID : 0,
        trailerURL : "placeholder",
        trailerGameID : 0
    };

    var picture = {
        picID : 0,
        picURL : "placeholder",
        picGameID : 0
    };

    var composer = {
        compID : generateRandomID(),
        compFN : $("#row6-0").val(),
        compLN : null,
        compOSTs : null,
        compGAME : game.gameID
    };

    var musician = {
        artID : 0,
        artNAME : "placeholder",
        artPFP : "placeholder"
    };

    var writers = {
        writerID : 0,
        writerFN : "placeholder",
        writerLN : "placeholder",
        writerGAME : "placeholder"
    };

    var actor = {
        acID : 0,
        acFN : "placeholder",
        acLN : "placeholder",
        acBDAY : "placeholder",
        acCHs : "placeholder",
        acGAME : 0,
        acPFP : "placeholder"
    };

    var genre = {
        genID : 0,
        genTITLE : "placeholder",
        genGAME : 0
    };




    game.gameNAME.push("hey");
    game.gameNAME.push("omg");
    for (var i = 0; i < game.gameNAME.length; i++) {
        alert(game.gameNAME[i]);
    }

    alert(game.gameNAME);
    alert(getCharacter());

});

function getCharacterList (id){
    var characterList = [];
    row11counter = 0;
    while ($("#row11Name-" + row11counter).val() !== undefined) {
        alert("we went through the while loop");
        if ($("#row11Name-" + row11counter).val() === ""){
            continue;
        }else {
            alert("we went through the if statement");
            var character = {
                chID : generateRandomID(),
                chNAME : $("#row11Name-"+row11counter),
                chPFP : $("#row11URL-"+row11counter),
                chGAME : id
            };
            characterList.push(character);
        }
        row11counter++;
    }
    return characterList;
}

function generateRandomID(){
    var dateObjekt = new Date();
    var milliseconds = dateObjekt.getTime();

    return milliseconds;
}

function getMusicArtists(){

}

$("#testButton").click(function () {
    /*row11counter = 0;
    var character ={
        chID : generateRandomID(),
        chNAME : $("#row11Name-"+row11counter).val(),
        chPFP : $("#row11URL-"+row11counter).val(),
        chGAME : 50
    };

    row11counter++;

    var character2 ={
        chID : generateRandomID(),
        chNAME : $("#row11Name-"+row11counter).val(),
        chPFP : $("#row11URL-"+row11counter).val(),
        chGAME : 50
    };

    alert(JSON.stringify(character, null, 4));
    alert(JSON.stringify(character2, null, 4));*/

    var list = getCharacterList(50);
    for (var i = 0; i < row11counter; i++) {
        var json = JSON.stringify(list[i], null, 4);
        alert(json);
    }
});
//FØRSTE VERSION AF CREATE GAME FUNKTIONALITETEN. SAT PÅ PAUSE FORDI DET VAR KOMPLICERET
/*$("#createGameForm").submit(function (event) {
    event.preventDefault();
    var data = $(this).serializeArray();
    var newArray = new Array();
    newArray.push("hey");
    newArray.push("hi");
    //var newArraySerialized =JSON.stringify(newArray) ;
    //newArraySerialized.push({name : "newValueFromNewArray", value : "OMG BRO Hvis Det Her virker så køber jeg en lotto plade"});
    data.push({name : "newValue", value : "detHerErDenNyeValueOgDetKanVæreSejtHvisDetteVirkede"});
    data.push({name : "list", value : newArray});
    //data = data.concat(newArraySerialized);
    $.ajax({
        type : $(this).attr("method"),
        url : $(this).attr("action"),
        data : $.param(data),
        success : function (data) {
            alert("success");
        },
        error : function () {
            alert("error");
        }
    });
});*/

/*$("#registerForm").submit(function (event) {
    event.preventDefault();
    $.ajax({
        type : $(this).attr("method"),
        url : $(this).attr("action"),
        data : $(this).serialize(),
        success : function (data) {
            if (data == "true"){
                alert("Your new account has been created successfully!");
                location.href = "Login_Signup.html"
            }else{
                alert("Couldn't create user. This username might be taken. Try again.")
            }
        },
        error : function () {
            alert("Couldn't create user, try again");
        }
    });
});*/