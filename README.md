| Método | Ruta          | Body (JSON)                                                                       | Descripción                     | Respuestas posibles            |
| ------ | ------------- | --------------------------------------------------------------------------------- | ------------------------------- | ------------------------------ |
| POST   | /carrito      | `{ "idArticulo": 1, "descripcion": "Libro", "unidades": 2, "precioFinal": 30.0 }` | Crea un nuevo carrito           | 201 Created / 400 Bad Request  |
| GET    | /carrito/{id} | -                                                                                 | Obtiene un carrito por id       | 200 OK / 404 Not Found         |
| PUT    | /carrito/{id} | `{ "unidades": 3 }`                                                               | Actualiza el número de unidades | 200 OK / 404 Not Found         |
| DELETE | /carrito/{id} | -                                                                                 | Elimina un carrito              | 204 No Content / 404 Not Found |
| GET    | /carrito      | -                                                                                 | Obtiene todos los carritos      | 200 OK                         |
