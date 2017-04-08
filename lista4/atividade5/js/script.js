/**
 * Created by gabriel on 07/04/17.
 */
var palavra = document.getElementById('texto');

var movimentar_palavra = function () {
    palavra.position(MouseEvent.getPosition());
}

palavra.addEventListener('mousemove', movimentar_palavra);