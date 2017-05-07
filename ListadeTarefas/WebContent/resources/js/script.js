$(() => {
	$('#login').submit(function (event) {
		var data = $(this).serialize();
		$.post('login', data, (res) => {
			if (res == 'success')
				window.location.href = "index.html";
			else {
				$('#error').html("<ul><li></li></ul>");
				$('#error li').text("Usuário e/ou senha inválida!");
				$('#error').addClass("alert alert-danger");
			}
		});
		event.preventDefault();
	});
});