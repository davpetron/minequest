# 1. Contexto de la aplicación

## 1.1. Problema que se pretende resolver

En Minecraft, los jugadores pueden llevar a cabo numerosas actividades: construir estructuras, conseguir materiales, explorar el mundo, crear granjas o desarrollar mecanismos de redstone.

Cuando un jugador tiene varios objetivos pendientes, resulta complicado organizarlos y recordar qué queda por hacer y qué es más importante. El problema crece en un servidor compartido entre amigos, donde varias personas trabajan a la vez: es habitual que se repitan tareas o que otras se queden sin hacer.

MineQuest surge para facilitar esta organización, tanto para quien juega solo como para grupos de amigos: permite registrar las tareas, clasificarlas y consultarlas según su importancia.

## 1.2. Aplicaciones y alternativas existentes

Actualmente, los jugadores organizan sus objetivos con herramientas genéricas de gestión de tareas, aplicaciones de notas, mensajes en grupos de chat o anotaciones fuera del propio juego.

Estas herramientas no están orientadas a las actividades específicas de Minecraft, por lo que no permiten clasificar las tareas según el tipo de trabajo que suponen dentro del juego.

MineQuest plantea una alternativa centrada en este entorno, con categorías propias de las actividades habituales del juego: Construcción, Minería, Recolección, Granjas, Redstone, Exploración, Decoración y Combate.

## 1.3. Propuesta de solución

MineQuest es una aplicación web destinada a organizar y gestionar las tareas que los jugadores quieren realizar en Minecraft, ya sea en su propio mundo o en un servidor compartido.

La aplicación permite crear nuevas tareas, consultar las existentes (todas o filtradas por prioridad), modificar su información y eliminarlas cuando ya no son necesarias.

Cada tarea contiene los siguientes datos:

| Dato | Descripción | Reglas |
|---|---|---|
| **Nombre** | Identifica la tarea. | Obligatorio, máximo 100 caracteres. |
| **Descripción** | Información adicional sobre lo que se quiere realizar. | Opcional, máximo 255 caracteres. |
| **Tipo** | Categoría de la tarea. | Obligatorio, uno de los ocho tipos admitidos. |
| **Prioridad** | Importancia de la tarea. | Número entre 1 y 5. |
| **Fecha de creación** | Momento en que se registró la tarea. | Se asigna automáticamente. |

## 1.4. Casos de uso

El actor principal de la aplicación es el jugador, que juega solo o en grupo e interactúa con MineQuest para gestionar sus tareas.

| Actor | Caso de uso | Descripción |
|---|---|---|
| Jugador | Consultar tareas | Obtiene el listado de todas las tareas registradas. |
| Jugador | Consultar tareas por prioridad | Obtiene solo las tareas que tienen una prioridad concreta. |
| Jugador | Crear tarea | Registra una nueva tarea con sus datos. |
| Jugador | Modificar tarea | Actualiza la información de una tarea existente. |
| Jugador | Eliminar tarea | Elimina una tarea registrada. |

## 1.5. Requisitos

### Requisitos funcionales

| Código | Requisito |
|---|---|
| RF01 | La aplicación debe permitir consultar el listado de tareas. |
| RF02 | La aplicación debe permitir consultar las tareas de una prioridad determinada. |
| RF03 | La aplicación debe permitir crear nuevas tareas. |
| RF04 | La aplicación debe permitir modificar tareas existentes. |
| RF05 | La aplicación debe permitir eliminar tareas. |
| RF06 | La aplicación debe validar los datos de entrada: nombre y tipo obligatorios, tipo dentro de los ocho admitidos y prioridad entre 1 y 5. |
| RF07 | La aplicación debe informar de los errores con un mensaje claro y el código HTTP adecuado (400, 404 o 500). |

### Requisitos no funcionales

| Código | Requisito |
|---|---|
| RNF01 | El código debe mantener una organización clara y separada por responsabilidades. |
| RNF02 | La arquitectura debe facilitar el mantenimiento y la ampliación de la aplicación. |
| RNF03 | Los mensajes de validación deben estar centralizados en un único fichero, separados del código. |
| RNF04 | Los errores no deben mostrar al usuario detalles internos de la aplicación. |

---

[Índice](../README.md) | [Siguiente: Diseño](02-diseno.md)