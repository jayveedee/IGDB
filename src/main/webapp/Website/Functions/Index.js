var startImage  = 1;
var i;
var images = document.getElementsByClassName("slideImages");
var counter;

window.addEventListener("load",function() {
    displayImage(startImage);
    counter = setInterval(function(){npImage(1)}, 4000);
})

// This controlls the next and prevs
function npImage(size){
  clearInterval(counter);
  if (size < 0){
    displayImage(startImage -= 1);
  } else {
    displayImage(startImage += 1); 
  }
  if (size == -1){
    counter = setInterval(function(){npImage(n + 2)}, 4000);
  } else {
    counter = setInterval(function(){npImage(n + 1)}, 4000);
  }
}

function displayImage(size){
  if (size > images.length) {startImage = 1}
  if (size < 1) {startImage = images.length}
  for (i = 0; i < images.length; i++) {
    images[i].style.display = "none";
  }

  images[startImage-1].style.display = "block";
}