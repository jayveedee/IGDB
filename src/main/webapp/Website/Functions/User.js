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
//This one does so you can see which avatar you have clicked on
$('img').click(function(){
    $('.selected').removeClass('selected');
    $(this).addClass('selected');
});
//This is for when you click on different avatars, and change the one on the site.
jQuery(document).ready(function($){

    $('.avatarStandard').on({
         'click': function(){
             $('#uploadedPicture').attr('src','https://imgur.com/y6rRbDc.png');
         }
     });
     
    $('.AvatarAnonymous').on({
         'click': function(){
             $('#uploadedPicture').attr('src','https://imgur.com/q2fKQdN.png');
         }
     });
     
    $('.AvatarBombe').on({
         'click': function(){
             $('#uploadedPicture').attr('src','https://imgur.com/qFMwjMD.png');
         }
     });
     
    $('.AvatarNinja').on({
         'click': function(){
             $('#uploadedPicture').attr('src','https://imgur.com/QsYFyAM.png');
         }
     });

     $('.AvatarWoman').on({
        'click': function(){
            $('#uploadedPicture').attr('src','https://imgur.com/CVRt9Ai.png');
        }
    });

    $('.AvatarYouAreAWizardHarry').on({
        'click': function(){
            $('#uploadedPicture').attr('src','https://imgur.com/UaXqUR1.png');
        }
    });
    });

    //Switch between show pass and hide pass
    function showPass() {
        if ($(".showAndHide").attr("type") === "password"){
            $(".showAndHide").attr("type", "text")
        } else {
            $(".showAndHide").attr("type", "password")
        }
    }


