const slideShowSlide = document.querySelector('.slideshow-slide');
const slideImages = document.querySelectorAll('.slideshow-slide img');

const prevBtn = document.querySelector('#prevBtn');
const nextBtn = document.querySelector('#nextBtn');

let counter = 1;
const size = slideImages[0].clientWidth;

slideShowSlide.style.transform = 'tranlateX(' + (-size * counter) +  'px)';

nextBtn.addEventListener('click',() => {
    slideShowSlide.style.transition = "transform 0.4s ease-in-out";
    counter++;
    slideShowSlide.style.transform = 'tranlateX(' + (-size * counter) +  'px)';
});

prevBtn.addEventListener('click',() => {
    slideShowSlide.style.transition = "transform 0.4s ease-in-out";
    counter++;
    slideShowSlide.style.transform = 'tranlateX(' + (-size * counter) +  'px)';
});