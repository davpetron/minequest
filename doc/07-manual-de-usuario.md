# 7. Manual de usuario

## 7.1. Introducción

En este apartado explicamos cómo utilizar las funcionalidades que ofrece actualmente MineQuest.

La aplicación permite consultar el listado de tareas, consultar las tareas de una prioridad, crear nuevas tareas, modificar las existentes y eliminarlas.

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

Desde este formulario podemos introducir los datos necesarios para registrar una nueva tarea en la aplicación:

- **Nombre:** obligatorio, de 100 caracteres como máximo.
- **Descripción:** opcional, de 255 caracteres como máximo.
- **Tipo:** se elige de la lista (Construcción, Minería, Recolección, Granjas, Redstone, Exploración, Decoración o Combate).
- **Prioridad:** un número del 1 al 5.

## 7.5. Modificar una tarea

La modificación de una tarea se realiza mediante una petición HTTP `PUT`.

Para ello, podemos utilizar el comando `curl` desde una terminal. Por ejemplo, el siguiente comando modifica la tarea con identificador `1`:

```bash
curl -i -X PUT http://localhost:8080/tareas/1 \
-H "Content-Type: application/json" \
-d '{"nombre":"Levantar las paredes del castillo","descripcion":"Muros de 8 bloques de alto","tipo":"Construcción","prioridad":5}'
```

En este ejemplo se envían los siguientes datos:

- **nombre:** nombre de la tarea.
- **descripcion:** nueva descripción de la tarea.
- **tipo:** tipo de la tarea.
- **prioridad:** nueva prioridad de la tarea.

Hay que enviar siempre los cuatro datos, también los que no cambian, ya que se aplican las mismas validaciones que al crear una tarea. El identificador y la fecha de creación se mantienen.

El identificador incluido en la dirección indica qué tarea queremos modificar.

## 7.6. Eliminar una tarea

Para eliminar una tarea, realizamos una petición HTTP `DELETE` desde una terminal.

Por ejemplo, el siguiente comando elimina la tarea con identificador `1`:

```bash
curl -i -X DELETE http://localhost:8080/tareas/1
```

El identificador incluido en la dirección indica qué tarea queremos eliminar.

## 7.7. Consultar tareas por prioridad

Para consultar solo las tareas de una prioridad concreta, accedemos desde el navegador a la siguiente dirección, indicando la prioridad al final (del 1 al 5):

`http://localhost:8080/tareas/prioridad/4`

Si no hay ninguna tarea con esa prioridad, la aplicación lo indica con el mensaje "No hay tareas con prioridad 4".

## 7.8. Mensajes de error

Cuando algo no es correcto, la aplicación muestra una página de error con la fecha, el código y un mensaje que explica el problema:

| Situación | Mensaje |
|---|---|
| Nombre vacío | El nombre de la tarea no puede estar vacío |
| Tipo vacío | El tipo de la tarea no puede estar vacío |
| Tipo que no existe | El tipo no es válido (Construcción, Minería, Recolección, Granjas, Redstone, Exploración, Decoración o Combate) |
| Prioridad menor que 1 o mayor que 5 | La prioridad no puede ser inferior a 1 / superior a 5 |
| Tarea que no existe | tarea con id 99 no encontrada |
| Prioridad sin tareas | No hay tareas con prioridad 1 |
| Identificador que no es un número | El parámetro id debe ser un número |
| Dirección que no existe | La ruta solicitada no existe |

---

[Anterior: Elementos destacables](06-elementos-destacables.md) | [Índice](../README.md) | [Siguiente: Conclusiones](08-conclusiones.md)