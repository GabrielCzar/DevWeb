var getCookie = (cname) => {
    var name = cname + "=";
    var cookies = decodeURIComponent(document.cookie).split(';');
    for(var i = 0; i < cookies.length; i++) {
        var c = cookies[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

$(() => {
	$(window).on('load', (event) => {
		/* var cookie = $.cookie('contador'); */
		var cookie = getCookie('contador');
		$('#quantidade').text(cookie);
		event.preventDefault();
	});
});