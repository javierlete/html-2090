var inputNombre = document.querySelector('#nombre');
var boton = document.querySelector('button');
var spanRespuesta = document.querySelector('#respuesta');

console.log(inputNombre, boton, spanRespuesta);

boton.addEventListener('click', saludar);

function saludar() {
    spanRespuesta.innerText = 'Hola ' + inputNombre.value;
}
