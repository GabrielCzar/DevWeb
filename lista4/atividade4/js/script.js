/**
 * Created by gabriel on 07/04/17.
 */
'use strict';

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

var imc = function (peso, altura) {
    return (peso / (altura * altura)).toFixed(4);
}

var alterar = function (peso, altura) {
    var _imc = imc(peso, altura);
    resultado.value = _imc;
    classificacao.innerHTML = mostrar_classificacao(_imc);
}

$(document).ready(function(){
    var peso = $('#peso')
    ,   altura = $('#altura')
    ,   res = $('#resultado')
    ,   clas = $('#classificacao');
    peso.keyup(alterar(peso, altura));
    altura.keyup(alterar(peso, altura));
});

