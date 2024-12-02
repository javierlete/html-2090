var nombre = prompt('Dime tu nombre');

if (nombre === 'Javier') {
    alert('Hola profe');
} else if (nombre === 'Pepe') {
    alert('Hola ejemplo de programación');
} else {
    alert('Hola ' + nombre);
}

switch(nombre) {
    case 'Javier':
        alert('Hola de nuevo profe');
        break;
    case 'Pepe':
        alert('Hola otra vez, ejemplo');
        break;
    default:
        alert('Hola de nuevo ' + nombre);
}

alert('Fin');