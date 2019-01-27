$(document).ready(function () {

    $('.gk-flat').click(function () {
        const flatId = $(this).attr('data-flat-id');
        const flatNumber = $(this).text();
        $('#flatID').val(flatId);
        $('#flatNumber').text(flatNumber);
    });
    $('#edit').click(function () {
        $('.gk-flat-holder').sortable({
            items: '> .gk-flat',
            connectWith: '.gk-flat-holder',
            update: function (event, ui) {
                // var posX = ui.item.parent().children().index(ui.item);
                $('.gk-flat-holder').each(function () {
                    if ($(this).children().length > 1) {
                        $(this).css({
                            'background-color': 'red',
                            'border-color' : 'red'
                        })

                    } else {
                        $(this).css({
                            'background-color': 'inherit'
                        })
                    }
                });
            },

        }).disableSelection;
    })

});

