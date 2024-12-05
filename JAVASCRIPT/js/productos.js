window.addEventListener('DOMContentLoaded', documentoCargado);

let productos, tabla, lista;

const URL = 'http://localhost:3000/productos/';

async function documentoCargado() {
    lista = document.querySelector('dl');
    tabla = document.querySelector('table');
    const tbody = document.querySelector('tbody');

    const respuesta = await fetch(URL);
    productos = await respuesta.json();

    console.log(productos);

    for (let producto of productos) {
        const tr = document.createElement('tr');

        tr.innerHTML = `
            <td>
                <a href="javascript:mostrarProducto(${producto.id})">
                    ${producto.nombre}
                </a>
            </td>
            
            <td>${producto.precio}</td>
        `;

        tbody.appendChild(tr);
    }
}

async function mostrarProducto(id) {
    console.log(id);

    lista.innerHTML = '';
    lista.style.display = 'block';

    const respuesta = await fetch(URL + id);
    const producto = await respuesta.json();

    tabla.style.display = 'none';

    const dt = document.createElement('dt');
    const dd = document.createElement('dd');

    dt.innerText = producto.nombre + ': ' + producto.precio;
    dd.innerText = producto.descripcion;

    lista.appendChild(dt);
    lista.appendChild(dd);
}

function verTabla() {
    tabla.style.display = 'block';

    lista.style.display = 'none';
}