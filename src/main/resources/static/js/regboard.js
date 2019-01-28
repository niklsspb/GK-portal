$(document).ready(function () {

    $('.gk-flat').click(function () {
        var flat = constructFlatObject($(this));
        $('#porchNumber').val(flat.porch);
        $('#floorNumber').val(flat.floor);
        $('#flatNumber').val(flat.flatNumber);
    }).disableSelection().mouseenter(function () {
        $('body').css({cursor: 'pointer'})
    }).mouseleave(function () {
        $('body').css({cursor: 'auto'})
    });



});

