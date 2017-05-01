'use strict';

$(() => {	
	$('#prod1', '#prod2', '#prod3').submit((event) => {
		var	data = $(this).serialize();
		$.post('add_produto', data, (res) => {
			$('button span').text(res); 
		});
		event.preventDefault();
	});
	$('#finalizar').click((e) => {
		$.get('finalizar_carrinho', () => {
			$('button span').text(0);
			$('div.modal-body').text("");
		});
		e.preventDefault();
	});
	$('#update').click((e) => {
		$.get('carrinho', (conteudo) => {
			$('div.modal-body').html(conteudo);
			$('table').addClass('table');
		});
		$.get('quantidade_carrinho', (qtd) => {
			$('button span').text(qtd);
		});
		e.preventDefault();
	});
	$(window).on('load', (e) => {
		$.get('quantidade_carrinho', (qtd) => {
			$('button span').text(qtd);
		});
		e.preventDefault();
	});
});
