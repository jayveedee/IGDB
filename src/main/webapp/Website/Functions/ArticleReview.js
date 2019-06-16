var i;
var i2;
var slides = document.getElementsByClassName("slideImages");
var videos = document.getElementsByClassName("slideVids");


//Shows the first picture, and only the first.
var slideIndex = 1;
var slideIndex2 = 1;
showSlides(slideIndex);
showSlides2(slideIndex2);

//Does so the button works.
function plusSlides(image) {
  showSlides(slideIndex += image);
}

function plusVideos(video){
  showSlides2(slideIndex2 += video);
}

function showSlides(image){
    if (image > slides.length){slideIndex = 1}
    if (image < 1){slideIndex = slides.length}
    //This forloop check that if there is more than one picture, than it should be displayed as none, so only picture are shown.
    for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
    }
    slides[slideIndex - 1].style.display = "block";
}

function showSlides2(video){
    if (video > videos.length){slideIndex2 = 1}
    if (video < 1){slideIndex2 = videos.length}

    for(i2 = 0; i2 < images.length; i2++){
        videos[i2].style.display = "none";
    }
    videos[slideIndex2 - 1].style.display = "block";
}