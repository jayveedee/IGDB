//For modal element
var modal = document.getElementById('simpleModal');
//For the "open modal" button
var modalBtn = document.getElementById('modalBtn');
//For closing the modal
var closeBtn = document.getElementsByClassName('closeBtn')[0];

//Checks if there happened a click
modalBtn.addEventListener('click', openModal);
//Checks if there happened a close click
closeBtn.addEventListener('click', closeModal);
//Checks if the user clicked outside the modal
window.addEventListener('click', clickOutSideWindow);

//To open the Modal
function openModal(){
    modal.style.display = 'block';
}
//To close the modal
function closeModal(){
    modal.style.display = 'none';
}

//Closes the modal when user clicks outside the Modal
function clickOutSideWindow(e){
    if(e.target == modal){
        modal.style.display = 'none';
    }
}
//This one gives a visual that you have clicked on a avatar (Links to CSS)
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


//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)