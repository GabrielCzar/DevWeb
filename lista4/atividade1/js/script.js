'use strict';

var preco = document.getElementById('input_preco') || 0
,   quantidade = document.getElementById('input_quantidade') || 0
,   resultado = document.getElementById('input_resultado') || 0;

var calcular = function () {
    resultado.value = preco.value * quantidade.value;
}

var addEvent = function (param) {
    param.addEventListener('change', calcular, true);
    param.addEventListener('keyup', calcular);
}

addEvent(preco);
addEvent(quantidade);
