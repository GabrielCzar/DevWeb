$(document).ready(function () {
    $('#palavra').css('position', 'absolute');
    $('html').mousemove(function (event) {
        $('#palavra').css({
            top: event.pageY,
            left: event.pageX
        });
    });
});




