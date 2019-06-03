const slideShowSlide = document.querySelector('.slideshow-container');
const slideImages = document.querySelectorAll('.slideshow-slide');

const prevBtn = document.querySelector('#prevBtn');
const nextBtn = document.querySelector('#nextBtn');

let counter = 1;
const size = slideShowSlide[0].clientWidth;

slideShowSlide.style.transform = 'tranlateX(' + (-size * counter) +  'px)';

nextBtn.addEventListener('click',()=>{
    slideShowSlide.style.transition = "transform 0.4s ease-in-out";
}