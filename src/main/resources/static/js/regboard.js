$(document).ready(function () {

    $('.gk-flat').click(function clickFlat(th) {
        var flat = constructFlatObject($(th));
        $('#porchNumber').val(flat.porch);
        $('#floorNumber').val(flat.floor);
        $('#flatNumber').val(flat.flatNumber);
    }).disableSelection().mouseenter(function () {
        $('body').css({cursor: 'pointer'})
    }).mouseleave(function () {
        $('body').css({cursor: 'auto'})
    });

});

