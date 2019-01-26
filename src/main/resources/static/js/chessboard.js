$(document).ready(function () {
    $('.gk-flatblock').each(function () {
        var height = $(this).attr('data-floor-count')*20+150;
        var width = $(this).attr('data-flats-per-floor')*30+50;
        $(this).css({width:width, height:height, position:'relative'});
    });
    $('.gk-flat').css('position', 'absolute');
    $('.gk-flat').click(function () {
        var riser = parseInt($(this).attr('data-riser'))+1;
        $(this).attr('data-riser', riser);
        arrange();
    });
    arrange();
});

function arrange() {
    //console.log("Call arrange");
    $('.gk-flat').each(function () {
        var yOffset = $(this).attr('data-floor')*20;
        var xOffset = $(this).attr('data-riser')*30;
        //console.log(height);
        $(this).css({top:yOffset, left: xOffset});
    })
}