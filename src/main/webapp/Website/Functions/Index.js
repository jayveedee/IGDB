/*
var slideshowContainer = document.querySelector('.slideshow-container');
var carouselImages = document.querySelectorAll('.slideshow-container img')

var counter = 1;
var size = carouselImages[0].clientWidth;

slideshowContainer.style.transform = 'translateX(' +(-size * counter) + 'px)';

nextBtn.addEventListener('click',()=>{

    slideshowContainer.style.transition = "transform 0.4s ease-in-out";
    counter++;
    slideshowContainer.style.transform = 'translateX(' + (-size * counter) + 'px)';
});

prevBtn.addEventListener('click',()=>{
    slideshowContainer.style.transition = "transform 0.4s ease-in-out";
    counter--;
    slideshowContainer.style.transform = 'translateX(' + (-size * counter) + 'px)';
});

slideshowContainer.addEventListener('transitionend', () =>{
    if (carouselImages[counter].id === 'lastClone'){
        slideshowContainer.style.transition = "none";
        counter = carouselImages.length - 2;
        slideshowContainer.style.transform = 'translateX(' +(-size * counter) + 'px)';
    }
    if (carouselImages[counter].id === 'firstClone'){
        slideshowContainer.style.transition = "none";
        counter = carouselImages.length - counter;
        slideshowContainer.style.transform = 'translateX(' +(-size * counter) + 'px)';
    }
});


var slideIndex = 1;

var myTimer;

window.addEventListener("load",function() {
    showSlides(slideIndex);
    myTimer = setInterval(function(){plusSlides(1)}, 4000);
})



// NEXT AND PREVIOUS CONTROL
function plusSlides(n){
    clearInterval(myTimer);
    if (n < 0){
        showSlides(slideIndex -= 1);
    } else {
        showSlides(slideIndex += 1);
    }
    if (n === -1){
        myTimer = setInterval(function(){plusSlides(n + 2)}, 4000);
    } else {
        myTimer = setInterval(function(){plusSlides(n + 1)}, 4000);
    }
}

//Controls the current slide and resets interval if needed
function currentSlide(n){
    clearInterval(myTimer);
    myTimer = setInterval(function(){plusSlides(n + 1)}, 4000);
    showSlides(slideIndex = n);
}

function showSlides(n){
    var i;
    var slides = document.getElementsByClassName("slideImages");
    var dots = document.getElementsByClassName("dot");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
}
*/


var slideIndex = 0;
var images = document.getElementsByClassName("slideImages");

showSlides();

function showSlides(n) {
    var i;
    for (i = 0; i < images.length; i++) {
        images[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > images.length) {slideIndex = 1}
    if (slideIndex < 1) {slideIndex = images.length}

    images[slideIndex - 1].style.display = "block";
    setTimeout(showSlides, 5000); // Change image every 5 seconds
}

function currentSlide(no) {
    var i;
    for (i = 0; i < images.length; i++) {
        images[i].style.display = "none";
    }
    slideIndex = no;
    images[no-1].style.display = "block";
}

function plusSlides(n) {
    var newslideIndex = slideIndex + n;
    if(newslideIndex < 6 && newslideIndex >= 0){
        currentSlide(newslideIndex);
    }
}