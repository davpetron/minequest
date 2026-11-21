# 1. Contexto de la aplicación

## 1.1. Problema que se pretende resolver

En Minecraft, los jugadores pueden llevar a cabo numerosas actividades, como construir estructuras, conseguir materiales, explorar el mundo, crear granjas o desarrollar estructuras de redstone.

Cuando un jugador tiene varios objetivos pendientes, puede resultar complicado organizarlos y recordar todos los pasos que necesita realizar para completarlos.

MineQuest surge como una propuesta para facilitar esta organización, permitiendo registrar las tareas que el jugador quiere realizar y consultar la información de cada una de ellas.

## 1.2. Aplicaciones y alternativas existentes

Actualmente, los jugadores pueden organizar sus objetivos mediante herramientas genéricas de gestión de tareas, aplicaciones de notas o anotaciones realizadas fuera del propio juego.

Sin embargo, estas herramientas no están necesariamente orientadas a las actividades específicas de Minecraft.

MineQuest plantea una alternativa centrada en este entorno, incorporando categorías relacionadas con las actividades habituales del juego, como Construcción, Minería, Recolección, Granjas, Redstone, Exploración, Decoración y Combate.

## 1.3. Nuestra propuesta de solución

MineQuest es una aplicación destinada a organizar y gestionar las tareas que los jugadores quieren realizar en sus mundos de Minecraft.

La aplicación permite crear nuevas tareas, consultar las existentes, modificar su información y eliminarlas cuando ya no sean necesarias.

Cada tarea contiene los siguientes datos:

- **Nombre:** identifica la tarea.
- **Descripción:** proporciona información adicional sobre lo que se quiere realizar.
- **Tipo:** clasifica la tarea según su categoría.
- **Prioridad:** indica la importancia de la tarea.
- **Fecha de creación:** registra cuándo se creó.

De esta forma, MineQuest busca ofrecer una herramienta sencilla y adaptada a las necesidades de organización de los jugadores de Minecraft.

## 1.4. Casos de uso

El actor principal de la aplicación es el jugador, que interactúa con MineQuest para gestionar sus tareas.

| Actor | Caso de uso | Descripción |
|---|---|---|
| Jugador | Consultar tareas | Permite obtener el listado de tareas registradas. |
| Jugador | Crear tarea | Permite registrar una nueva tarea con sus datos. |
| Jugador | Modificar tarea | Permite actualizar la información de una tarea existente. |
| Jugador | Eliminar tarea | Permite eliminar una tarea registrada. |

## 1.5. Requisitos

### Requisitos funcionales

| Código | Requisito |
|---|---|
| RF01 | La aplicación debe permitir consultar el listado de tareas. |
| RF02 | La aplicación debe permitir crear nuevas tareas. |
| RF03 | La aplicación debe permitir modificar tareas existentes. |
| RF04 | La aplicación debe permitir eliminar tareas. |

### Requisitos no funcionales

| Código | Requisito |
|---|---|
| RNF01 | El código debe mantener una organización clara y separada por responsabilidades. |
| RNF02 | La arquitectura debe facilitar el mantenimiento y la ampliación de la aplicación. |
| RNF03 | La aplicación debe utilizar tecnologías adecuadas para el desarrollo de aplicaciones web. |

---

[Índice](../README.md) | [Siguiente: Diseño ](02-diseno.md)