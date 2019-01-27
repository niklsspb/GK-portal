$(document).ready(function () {

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
                        });
                    }
                });
                const flat = ui.item;
                if (!(flat.parent().children().length>1)){
                    const fNumber = flat.children('.gk-flat-number').text();
                    const fId = flat.attr('data-flat-id');
                    const fBuildNumber = flat.children('.gk-flat-build-number').text();
                    const fFloor = flat.parent().parent().attr('data-floor-number');
                    const fRizer = flat.parent().attr('data-rizer-number');
                    const fPorch = flat.parent().parent().parent().attr('data-porch-number');
                    alert('Теперь у квартиры с id: ' + fId + '\nномер '+ fNumber + '; строительный номер ' + fBuildNumber
                        +'\nномер этажа ' + fFloor + '; номер стояка '+ fRizer
                        + '\nв '+ fPorch + ' подъезде')
                }
            },
        }).disableSelection;
    })

});

