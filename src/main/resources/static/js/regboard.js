$(document).ready(function () {

    $('.gk-flat').click(function () {
        const flatId = $(this).attr('data-flat-id');
        const flatNumber = $(this).text();
        $('#flatID').val(flatId);
        $('#flatNumber').text(flatNumber);
    });



});

