$(document).on("click", ".btn-add-row", function(){
    var row = $(".row").eq(0).clone().show();

    $(".element-wrapper").append(row)
});

$(document).on("click", ".btn-remove-row", function(){
   var index = $(".btn-remove-row").index(this);
   $(".row").eq(index).remove();
});


$(document).on("click", ".btn-add-row2", function(){
    var row2 = $(".row2").eq(0).clone().show();

    $(".element-wrapper2").append(row2)
});

$(document).on("click", ".btn-remove-row2", function(){
    var index2 = $(".btn-remove-row2").index(this);
    $(".row2").eq(index2).remove();
});

$(document).on("click", ".btn-add-row3", function(){
    var row3 = $(".row3").eq(0).clone().show();

    $(".element-wrapper3").append(row3)
});

$(document).on("click", ".btn-remove-row3", function(){
    var index3 = $(".btn-remove-row3").index(this);
    $(".row3").eq(index3).remove();
});