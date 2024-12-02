'use strict';

/*
Ejemplo de JavaScript

Pequeño programa básico
*/
console.log('Hola qué tal'); // Muestra por la consola el texto

var nombre = 'Javier';

console.log(typeof nombre, nombre);

nombre = prompt('Dime tu nombre');

console.log('Hola ' + nombre);

var a = +prompt('Dime un número');
var b = parseInt(prompt('Dime otro número'));

console.log(typeof a, a);
console.log(typeof b, b);

console.log(a + b);
console.log(a == b);

var sonIguales = a == b;

console.log(typeof sonIguales, sonIguales);

var prueba;

console.log(typeof prueba, prueba);

var titulo = document.querySelector('h1');

console.log(titulo.innerText);

titulo.innerText = 'Modificado';
titulo.style = 'color: red';
