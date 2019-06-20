var startImage  = 1;
var i;
var images = document.getElementsByClassName("slideImages");
var counter;
//The type is load, because we want it to start with the slideshow as soon as someone goes into the website
window.addEventListener("load",function() {
  //This one starts the slideshow
  displayImage(startImage);
  counter = setInterval(function(){npImage(1)}, 4000);
});

// This controls the "next" and "prev"
function npImage(size){
  clearInterval(counter);
  if (size < 0){
    displayImage(startImage -= 1);
  } else {
    displayImage(startImage += 1);
  }
  //It have to be 2 and 1, for the slideshow to move it to the next and not prev.
  if (size == -1){
    counter = setInterval(function(){npImage(size + 2)}, 4000);
  } else {
    counter = setInterval(function(){npImage(size + 1)}, 4000);
  }
}

function displayImage(size){
  //This if statement does so you loop back to the first image, when you press "next", and the else if does the same for the "prev".
  if (size > images.length) {startImage = 1}
  if (size < 1) {startImage = images.length}
  //This does so the images changes from not being displayed to be displayed as a "block".
  for (i = 0; i < images.length; i++) {
    images[i].style.display = "none";
  }

  images[startImage-1].style.display = "block";
}