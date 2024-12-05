window.addEventListener('DOMContentLoaded', documentoCargado);

let productos, tabla, lista;

async function documentoCargado() {
    lista = document.querySelector('dl');
    tabla = document.querySelector('table');
    const tbody = document.querySelector('tbody');

    const respuesta = await fetch('json/productos.json');
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

function mostrarProducto(id) {
    console.log(id);

    const producto = { id, nombre: 'nombre' + id, precio: id * 5, descripcion: 'descripcion' + id };

    tabla.style.display = 'none';

    const dt = document.createElement('dt');
    const dd = document.createElement('dd');

    dt.innerText = producto.nombre + ': ' + producto.precio;
    dd.innerText = producto.descripcion;

    lista.appendChild(dt);
    lista.appendChild(dd);
}