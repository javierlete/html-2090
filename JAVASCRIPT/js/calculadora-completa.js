console.log('CALCULADORA COMPLETA');

let op1, op2, op;

const pantalla = document.querySelector('input');
console.log(pantalla);

const botones = document.querySelectorAll('button');
console.log(botones);

// for (let i = 0; i < botones.length; i++) {
//     console.log(i, botones[i]);
// }

for(let boton of botones) {
    console.log(boton);

    boton.addEventListener('click', botonPulsado);
}

console.log('FIN');

function botonPulsado(evento) {
    console.log('PULSADO');

    const etiqueta = evento.target.innerText;

    console.log(etiqueta);

    if(etiqueta >= '0' && etiqueta <= '9') {
        console.log('NUMERO');

        pantalla.value = pantalla.value + etiqueta;
        // pantalla.value += etiqueta;
    } else {
        switch(etiqueta) {
            case '+':
                op1 = +pantalla.value;
                op = '+';

                pantalla.value = '';

                break;
            case '=':
                op2 = +pantalla.value;

                switch(op) {
                    case '+':
                        pantalla.value = op1 + op2;
                        break;
                }
        }
    }
}