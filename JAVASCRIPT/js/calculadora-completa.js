console.log('CALCULADORA COMPLETA');

let op1, op2, op;

const pantalla = document.querySelector('input');
console.log(pantalla);

const botones = document.querySelectorAll('button');
console.log(botones);

// for (let i = 0; i < botones.length; i++) {
//     console.log(i, botones[i]);
// }

for (let boton of botones) {
    console.log(boton);

    boton.addEventListener('click', botonPulsado);
}

console.log('FIN');

function botonPulsado(evento) {
    console.log('PULSADO');

    const boton = evento.target;
    const etiqueta = boton.innerText;

    console.log(etiqueta);

    if (etiqueta >= '0' && etiqueta <= '9') {
        procesarNumero(etiqueta);
    } else {
        procesarOperacion(etiqueta);
    }
}

function procesarOperacion(etiqueta) {
    switch (etiqueta) {
        case 'C':
            pantalla.value = '';
            break;
        case '+':
        case '-':
        case 'X':
        case '/':
            operacionAritmetica(etiqueta);

            break;
        case '=':
            operacionIgual();
    }
}

function operacionIgual() {
    op2 = +pantalla.value;

    switch (op) {
        case '+':
            pantalla.value = op1 + op2;
            break;
        case '-':
            pantalla.value = op1 - op2;
            break;
        case 'X':
            pantalla.value = op1 * op2;
            break;
        case '/':
            if (op2) {
                pantalla.value = op1 / op2;
            } else {
                pantalla.value = 'ERROR';
            }

            break;
    }
}

function operacionAritmetica(etiqueta) {
    op1 = +pantalla.value;
    op = etiqueta;

    pantalla.value = '';
}

function procesarNumero(etiqueta) {
    console.log('NUMERO');

    pantalla.value = pantalla.value + etiqueta;
    // document.querySelector('input').value = document.querySelector('input').value + evento.target.innerText;
    // pantalla.value += etiqueta;
}
