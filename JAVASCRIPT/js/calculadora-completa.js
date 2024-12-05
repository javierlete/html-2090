console.log('CALCULADORA COMPLETA');

let op1, op2, op;

const main = document.querySelector('main');

crearBotonera();

const pantalla = document.querySelector('input');
console.log(pantalla);

document.addEventListener('keypress', teclaPulsada);

console.log('FIN');

function crearBotonera() {
    const etiquetas = [ 7, 8, 9, '/', 4, 5, 6, 'X', 1, 2, 3, '-', 'C', 0, '=', '+' ];

    for(let etiqueta of etiquetas) {
        const boton = document.createElement('button');

        boton.innerText = etiqueta;

        boton.addEventListener('click', botonPulsado);

        if(!(etiqueta >= 0 && etiqueta <= 9)) {
            boton.className = 'operacion';
        }

        console.log(boton);

        main.appendChild(boton);
    }
}

function teclaPulsada(evento) {
    const tecla = evento.key;

    console.log(tecla);

    procesarEtiqueta(tecla);
}

function botonPulsado(evento) {
    console.log('PULSADO');

    const boton = evento.target;
    const etiqueta = boton.innerText;

    console.log(etiqueta);

    procesarEtiqueta(etiqueta);
}

function procesarEtiqueta(etiqueta) {
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
            break;
        default:
            console.error("No se esperaba la función " + etiqueta);
            alert('Problema inesperado en la aplicación');
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
