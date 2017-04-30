window.onload = function () {
	document.onmousemove = function (event) {
		var palavra = document.getElementById('palavra');
			
		palavra.setAttribute('style', 'position:relative');
		
		palavra.style.top = event.clientY + 'px';
		palavra.style.left = event.clientX + 'px';
		
	}
}
