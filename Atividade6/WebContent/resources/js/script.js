'use strict';

/* PARTE REFERENTE AOS PRODUTOS */

var change_carrinho = (event, data) => {
	$.post('add_produto', data, (res) => {
		$('button span').text(res); 
	});
	event.preventDefault();
}

$(() => {	
	$('#prod1').submit((event) => {
		var	data = $('#prod1').serialize();
		change_carrinho (event, data);
	});
	$('#prod2').submit((event) => {
		var	data = $('#prod2').serialize();
		change_carrinho (event, data);
	});
	$('#prod3').submit((event) => {
		var	data = $('#prod3').serialize();
		change_carrinho (event, data);
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

/* PARTE REFERENTE AO CONTADOR */

$(() => {
	
})