/*--------------------------------------------------------------------------bt1*/
$(document).on("click", ".btn-add-row", function(){
    var row = $(".row").eq(0).clone().show();
    $(".element-wrapper").append(row)
});

$(document).on("click", ".btn-remove-row", function(){
   var index = $(".btn-remove-row").index(this);
   $(".row").eq(index).remove();
});

/*--------------------------------------------------------------------------bt2*/
$(document).on("click", ".btn-add-row2", function(){
    var row2 = $(".row2").eq(0).clone().show();
    $(".element-wrapper2").append(row2)
});

$(document).on("click", ".btn-remove-row2", function(){
    var index2 = $(".btn-remove-row2").index(this);
    $(".row2").eq(index2).remove();
});
/*--------------------------------------------------------------------------bt3*/
$(document).on("click", ".btn-add-row3", function(){
    var row3 = $(".row3").eq(0).clone().show();
    $(".element-wrapper3").append(row3)
});

$(document).on("click", ".btn-remove-row3", function(){
    var index3 = $(".btn-remove-row3").index(this);
    $(".row3").eq(index3).remove();
});
/*--------------------------------------------------------------------------bt4*/
$(document).on("click", "#btn4", function(){
    var row4 = $(".row4").eq(0).clone().show();
    $(".element-wrapper4").append(row4)
});

$(document).on("click", ".btn-remove-row4", function(){
    var index4 = $(".btn-add-row4").index(this);
    $(".row4").eq(index4).remove();
});
/*--------------------------------------------------------------------------bt5*/
$(document).on("click", ".btn-add-row5", function(){
    var row5 = $(".row5").eq(0).clone().show();
    $(".element-wrapper5").append(row5)
});

$(document).on("click", ".btn-remove-row5", function(){
    var index5 = $(".btn-remove-row5").index(this);
    $(".row5").eq(index5).remove();
});
/*--------------------------------------------------------------------------bt6*/
$(document).on("click", ".btn-add-row6", function(){
    var row6 = $(".row6").eq(0).clone().show();
    $(".element-wrapper6").append(row6)
});

$(document).on("click", ".btn-remove-row6", function(){
    var index6 = $(".btn-remove-row6").index(this);
    $(".row6").eq(index6).remove();
});
/*--------------------------------------------------------------------------bt7*/
$(document).on("click", ".btn-add-row7", function(){
    var row7 = $(".row7").eq(0).clone().show();
    $(".element-wrapper7").append(row7)
});

$(document).on("click", ".btn-remove-row7", function(){
    var index7 = $(".btn-remove-row7").index(this);
    $(".row7").eq(index7).remove();
});
/*--------------------------------------------------------------------------bt8*/
$(document).on("click", ".btn-add-row8", function(){
    var row8 = $(".row8").eq(0).clone().show();
    $(".element-wrapper8").append(row8)
});

$(document).on("click", ".btn-remove-row8", function(){
    var index8 = $(".btn-remove-row8").index(this);
    $(".row8").eq(index8).remove();
});
/*--------------------------------------------------------------------------bt9*/
$(document).on("click", ".btn-add-row9", function(){
    var row9 = $(".row9").eq(0).clone().show();
    $(".element-wrapper9").append(row9)
});

$(document).on("click", ".btn-remove-row9", function() {
    var index9 = $(".btn-remove-row9").index(this);
    $(".row9").eq(index9).remove();
});
/*--------------------------------------------------------------------------bt10*/
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
    var row11 = $(".row11").eq(0).clone().show();
    $(".element-wrapper11").append(row11)
});

$(document).on("click", ".btn-remove-row11", function() {
    var index11 = $(".btn-remove-row11").index(this);
    $(".row11").eq(index11).remove();
});
/*--------------------------------------------------------------------------bt12*/
$(document).on("click", "#btn12", function(){
    var row12 = $(".row12").eq(0).clone().show();
    $(".element-wrapper12").append(row12)
});

$(document).on("click", ".btn-remove-row12", function() {
    var index12 = $(".btn-remove-row12").index(this);
    $(".row12").eq(index12).remove();
});
/*--------------------------------------------------------------------------bt13*/
$(document).on("click", "#btn13", function(){
    var row13 = $(".row13").eq(0).clone().show();
    $(".element-wrapper13").append(row13)
});

$(document).on("click", ".btn-remove-row13", function() {
    var index13 = $(".btn-remove-row13").index(this);
    $(".row13").eq(index13).remove();
});


$("#createGameForm").submit(function (event) {
    event.preventDefault();
    var game ={
        gameNAME : "placeholder",
        gameCHs : [],
        gameACs : [],
        gameGENREs : [],
        gameGMs : [],
        gameRATINGs : [],
        gameRELEASEDATE : "placeholder",
        gameWRI : "placeholder",
        gameCOMP : "placeholder",
        gameDEV : "placeholder",
        gamePUB : "placeholder",
        gameOST : "placeholder",
        gamePLAT : [],
        gameCOVER : "placeholder",
        gameBG : "placeholder",
        gameBIO : "placeholder",
        gameTRAILERs : [],
        gamePICs : []
    };

    var plat={

    };
    game.gameNAME.push("hey");
    game.gameNAME.push("omg");
    for (var i = 0; i < game.gameNAME.length; i++) {
        alert(game.gameNAME[i]);
    }

    alert(game.gameNAME);

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