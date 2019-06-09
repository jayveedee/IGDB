$(document).on("click",".btn-add-row", function(){
    var row = $(".row").eq(0).clone().show();

    $(".element-wrapper").append(row)
});

$(document).on("click", ".btn-remove-row", function(){
   var index = $(".btn-remove-row").index(this);
   $(".row").eq(index).remove();
});