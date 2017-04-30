window.onload = function () {
	document.onmousemove = function () {
		var eixo_y = window.event.clientY
		,   eixo_x = window.event.clientX
		,   palavra = document.getElementById('palavra');
			
		palavra.setAttribute('style', 'position:relative');
		
		palavra.style.top = eixo_y + 'px';
		palavra.style.left = eixo_x + 'px';
		
	}
}
