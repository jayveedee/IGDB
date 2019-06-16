  var i;
  var slides = document.getElementsByClassName("slideImages");

//Shows the first picture, and only the first.
var slideIndex = 1;
showSlides(slideIndex);

//Does so the button works.
function plusSlides(image) {
  showSlides(slideIndex += image);
}

function showSlides(image) {
  if (image > slides.length) {slideIndex = 1}    
  if (image < 1) {slideIndex = slides.length}
  //This forloop check that if there is more than one picture, than it should be displayed as none, so only picture are shown.
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  slides[slideIndex-1].style.display = "block";  
}