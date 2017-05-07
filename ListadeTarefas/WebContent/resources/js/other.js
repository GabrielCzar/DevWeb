$(() => {
	var atualizar = () => {
		$.get('lista_tarefas', (data) => {
			$('#lista').html(data);
		});
	};
	
	$('#form_tarefa').submit(function (e) {
		var data = $(this).serialize();
		$.post('lista_tarefas', data, (res) => {
			var btn_msg = res == 'success' ? ['#success', 'Tarefa Adicionada!', 'alert alert-success'] : ['#error', 'Não foi possivel adicionar a tarefa!', 'alert alert-danger'];  
			$(btn_msg[0]).text(btn_msg[1]);
			$(btn_msg[0]).addClass(btn_msg[2]);
		});
		atualizar();
		e.preventDefault();
	});	
	
	var alterar_deletar = () => { 
		var data = $('th a');
		for (var v = 0; v < data.length; v++) 
			if (data[v].id.match('alterar'))
				console.log(data[v].id)	
	}
	
	$(window).on('load', function (e) {
		atualizar();
		event.preventDefault();
	});
});