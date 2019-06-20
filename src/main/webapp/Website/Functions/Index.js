var firstImage  = 1;
var i;
var img = document.getElementsByClassName("slideImages");
var counter;
//The type is load, because we want it to start with the slideshow as soon as someone goes into the website
window.addEventListener("load",function() {
  //This one starts the slideshow
  counter = setInterval(function(){npImage(1)}, 4000);
});

// This controls the "next" and "prev"
function npImage(size){
  clearInterval(counter);
  if (size < 0){
    displayImage(firstImage -= 1);
  } else {
    displayImage(firstImage += 1);
  }
  //The size have to be added by 1, for the image to move to the next and not prev.
  if (size === -1){
    counter = setInterval(function(){npImage(size + 1)}, 4000);
  } else {
    counter = setInterval(function(){npImage(size + 1)}, 4000);
  }
}

function displayImage(size){
  //This if statement does so you loop back to the first image, when you press "next", and the else if does the same for the "prev".
  if (size > img.length) {
    firstImage = 1;
  }
  if (size < 1) {
    firstImage = img.length;
  }
  //This does so the images changes from not being displayed to be displayed as a "block".
  for (i = 0; i < img.length; i++) {
    img[i].style.display = "none";
  }
  img[firstImage-1].style.display = "block";
}

$(document).ready(function () {
    $.ajax({
        type : "post",
        url : "/rest/services/game/getGameList",
        success : function (data) {
            var jsonObject = JSON.parse(data);
            var gameList = jsonObject.gameList;

            for (var j = 1; j <= 4; j++) {
                var randomNumber = Math.floor(Math.random()*gameList.length);
                $("#article"+j+"name").text(gameList[randomNumber].gameNAME);
                $("#article"+j+"pic").attr("src", gameList[randomNumber].gameCover);
                $("#article"+j+"bio").text(gameList[randomNumber].gameBIO);
            }
        },
        error : function () {
            alert("ajax call failed");
        }
    });
});