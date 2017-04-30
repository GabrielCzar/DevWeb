'use strict';

var imagens = ['img/cia.jpg', 'img/cibercalavera.jpg', 'img/diretor-google.jpg']
,   btnAcao = document.getElementById('acao')
,   img = document.querySelector('img')
,   cont = 0
,   pos = 0
,   tam = 3;

var trocarImage = () => {
  pos = (pos + 1) % tam;
  img.src = imagens[pos];
}

var timer = setInterval(trocarImage, 2000);

btnAcao.onclick = () => {
  if (cont % 2 == 0)
    clearInterval(timer);
  else {
    timer = setInterval(trocarImage, 2000);
    cont++;
  }
};