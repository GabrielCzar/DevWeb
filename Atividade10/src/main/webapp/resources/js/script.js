$(() => {
	$('#add').click(function () {
		$(this).hide();
		$('#form_add').fadeIn(1000);
	});
	
	$('#form_add').submit(function () {
		$(this).hide();
		$('#add').show();
	});
	
	$(window).load((e) => {
		var o = window.location.pathname.substr(0, window.location.pathname.lastIndexOf('/')) + '/produtos'
		
		if (o == location.pathname)
			return false;
		
		location.href = o
		e.preventDefault();
	});
});