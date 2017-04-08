/**
 * Created by gabriel on 07/04/17.
 */
'use strict';

var peso = document.getElementById('peso') || 0
,   altura = document.getElementById('altura') || 0
,   resultado = document.getElementById('resultado') || 0
,   classificacao = document.getElementById('classificacao');

var mostrar_classificacao = function (imc) {
    if (imc < 16)
        return "Magreze grave";
    else if (imc < 17)
        return "Magreza moderada";
    else if (imc < 18.5)
        return "Magreza leve";
    else if (imc < 25)
        return "Saudável";
    else if (imc < 30)
        return "Sobrepeso";
    else if (imc < 35)
        return "Obesidade Grau I";
    else if (imc < 40)
        return "Obesidade Grau II (severa)";
    else
        return "Obesidade Grau III (mórbida)";
}

var alterar = function () {
    var imc  = (peso.value / (altura.value * altura.value)).toFixed(4);
    resultado.value = imc;
    classificacao.innerHTML = mostrar_classificacao(imc);
}



var addEvent = function (param) {
    param.addEventListener('change', alterar, true);
    param.addEventListener('keyup', alterar);
}

addEvent(peso);
addEvent(altura);
