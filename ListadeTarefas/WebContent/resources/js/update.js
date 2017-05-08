$(() => {
	$(window).on('load', (e) => {
		var o = location.origin
		var l = 'ListadeTarefas'
		location.href = o + l
		e.preventDefault();
	})
})