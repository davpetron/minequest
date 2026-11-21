# 7. Manual de usuario

## 7.1. Introducción

En este apartado explicamos cómo utilizar las funcionalidades que ofrece actualmente MineQuest.

La aplicación permite consultar el listado de tareas, crear nuevas tareas, modificar las existentes y eliminarlas.

## 7.2. Acceso a la aplicación

Para utilizar la aplicación, primero debemos ejecutar el proyecto localmente con Spring Boot.

Una vez iniciada, podemos acceder a sus funcionalidades desde el navegador o mediante peticiones HTTP, dependiendo de la operación que queramos realizar.

La aplicación utiliza el puerto `8080` en el entorno local.

## 7.3. Consultar el listado de tareas

Para consultar las tareas registradas, accedemos a la siguiente dirección desde el navegador:

`http://localhost:8080/tareas`

Esta dirección permite obtener el listado de tareas almacenadas en la aplicación.

## 7.4. Crear una tarea

Para crear una nueva tarea, accedemos al siguiente formulario desde el navegador:

`http://localhost:8080/formulario-crear-tarea.html`


Desde este formulario podemos introducir los datos necesarios para registrar una nueva tarea en la aplicación.

## 7.5. Modificar una tarea

La modificación de una tarea se realiza mediante una petición HTTP `PUT`.

Para ello, podemos utilizar el comando `curl` desde una terminal. Por ejemplo, el siguiente comando modifica la tarea con identificador `1`:

```bash
curl -i -X PUT http://localhost:8080/tareas/1 \
-H "Content-Type: application/json" \
-d '{"descripcion":"Construir una granja automática","prioridad":3}'
```

En este ejemplo se envían los siguientes datos:

- **descripcion:** nueva descripción de la tarea.
- **prioridad:** nueva prioridad de la tarea.

El identificador incluido en la dirección indica qué tarea queremos modificar.
## 7.6. Eliminar una tarea

Para eliminar una tarea, realizamos una petición HTTP `DELETE` desde una terminal.

Por ejemplo, el siguiente comando elimina la tarea con identificador `1`:

```bash
curl -i -X DELETE http://localhost:8080/tareas/1
```

El identificador incluido en la dirección indica qué tarea queremos eliminar.

---

[Anterior: Elementos destacables](06-elementos-destacables.md) | [Índice](../README.md) | [Siguiente: Conclusiones](08-conclusiones.md)