/**
 * Created by gabriel.
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

var alterar = function () {
    var peso = $('#peso').val() || 0
    ,   altura = $('#altura').val() || 0;

    var _imc = imc(peso, altura);
    $('#resultado').val(_imc);
    $('#classificacao').text(mostrar_classificacao(_imc));
}

$('input').keyup(alterar);


