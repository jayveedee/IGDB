//For modal elementet
var modal = document.getElementById('simpleModal');
//for åbne modal knappen
var modalBtn = document.getElementById('modalBtn');
//for lukke modal knappen
var closeBtn = document.getElementsByClassName('closeBtn')[0];

//Ser om der sker et åben klik
modalBtn.addEventListener('click', openModal);
//Ser om der sker et lukke klik
closeBtn.addEventListener('click', closeModal);
//Klikker udenfor boksen
window.addEventListener('click', clickOutSideWindow);

//For at åbne modal
function openModal(){
    modal.style.display = 'block';
}

//For at åbne modal
function closeModal(){
    modal.style.display = 'none';
}

//Lukker boksen hvis man klikker udenfor boksen
function clickOutSideWindow(e){
    if(e.target == modal){
        modal.style.display = 'none';
    }
}



/*Skal ikke bruges længere
$(function() {
    function readURL(input) {
        if(input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#uploadedPicture').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
                }
            };
            $("#imageUpload").change(function(){
                readURL(this);
            });
            $("#uploadedPicture").click(function() {
                $("input[id='imageUpload']").click();
    });
});*/