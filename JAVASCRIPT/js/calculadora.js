'use strict';

console.log('Inicio JavaScript');

const op1 = document.querySelector('#op1');
console.log('op1', op1);

const op2 = document.querySelector('#op2');
console.log('op2', op2);

const op = document.querySelector('#op');
console.log('op', op);

const operar = document.querySelector('#operar');
console.log('operar', operar);

const resultado = document.querySelector('#resultado');
console.log('resultado', resultado);

operar.addEventListener('click', ejecutarOperacion);

function ejecutarOperacion() {
    console.log('EJECUTAR OPERACIÓN');

    switch(op.value) {
        case '+':
            console.log('SUMAR');

            const suma = +op1.value + +op2.value;

            console.log(suma);

            resultado.innerText = suma;

            break;
        case '-':
            console.log('RESTAR');

            const resta = +op1.value - +op2.value;

            console.log(resta);

            resultado.innerText = resta;

            break;
        case '*':
            console.log('MULTIPLICAR');

            const multiplicacion = +op1.value * +op2.value;

            console.log(multiplicacion);

            resultado.innerText = multiplicacion;
            
            break;
        case '/':
            console.log('DIVIDIR');

            const division = +op1.value / +op2.value;

            console.log(division);

            resultado.innerText = division;

            break;
        default:
            console.log('NO LO SE');
            break;
    }
}