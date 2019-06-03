var slideShowSlide = document.querySelector('.slideshow-slide');
var slideImages = document.querySelectorAll('.slideshow-slide img');

var prevBtn = document.querySelector('#prevBtn');
var nextBtn = document.querySelector('#nextBtn');

let counter = 1;
var size = slideImages[0].clientWidth;

slideShowSlide.style.transform = 'tranlateX(' + (-size * counter) +  'px)';

nextBtn.addEventListener('click',()=>{
   slideShowSlide.style.transition ="transform 0.4s ease-in-out";
   counter++;
   slideShowSlide.style.transform = 'tranlateX(' + (-size * counter) +  'px)';
});
