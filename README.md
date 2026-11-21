# MineQuest

**MineQuest** es una aplicación desarrollada como parte del examen práctico de la asignatura de Entorno Servidor.

El proyecto tiene como objetivo facilitar la organización y gestión de tareas de Minecraft, permitiendo a los jugadores planificar objetivos y llevar un seguimiento de las actividades que quieren realizar en sus mundos.

- **Versión:** 1.0.0
- **Integrantes:**
  - David Crisbasianu Petronga
  - Samuel Alonso Álvarez
  - Álvaro Cabrejas Ormeño

## Sobre el proyecto


La aplicación se organiza siguiendo una arquitectura basada en funcionalidades o ***Vertical Slicing***, separando el código en dos slices principales:

- **tarea:** contiene la funcionalidad relacionada con la gestión de tareas.
- **common:** agrupa los elementos compartidos que pueden utilizarse en distintas funcionalidades de la aplicación.

En cada uno de estos slices se ha aplicado ***Clean Architecture*** con el fin de separar tres capas con distintas responsabilidades: `domain`, `application` e `infraestructure`.

Con este desarrollo se garantiza la escalabilidad del proyecto de forma progresiva, permitiendo añadir funcionalidades nuevas sin comprometer el funcionamiento de las ya existentes.

## Funcionalidades

Actualmente, la aplicación contempla las siguientes operaciones para gestionar tareas:

| Método HTTP | Operación | Ruta |
|---|---|---|
| GET | Consultar tareas | `/tareas` |
| POST | Crear una tarea | `/tareas` |
| PUT | Modificar una tarea | `/tareas/{id}` |
| DELETE | Eliminar una tarea | `/tareas/{id}` |

Además, incluye: 
- Validación de datos en la creación y modificación, con una validación personalizada.
- Manejo global de errores, que devuelve el código HTTP correspondiente en cada caso (400, 404 y 500).

## Ejecución rápida
Se requiere Java 17 y Maven.

```bash
mvn spring-boot:run
```

Una vez iniciada, la aplicación está disponible en http://localhost:8080/tareas.

Más detalles en Ejecución y pruebas y en el Manual de usuario.

## Documentación

La documentación del proyecto se encuentra en la carpeta `doc/`, organizada en distintos archivos Markdown para facilitar su consulta.

| Apartado | Documento |
|---|---|
| 1. Contexto de la aplicación | [01-contexto.md](doc/01-contexto.md) |
| 2. Diseño | [02-diseno.md](doc/02-diseno.md) |
| 3. Implementación | [03-implementacion.md](doc/03-implementacion.md) |
| 4. Ejecución y pruebas | [04-ejecucion-y-pruebas.md](doc/04-ejecucion-y-pruebas.md) |
| 5. Herramientas y versiones | [05-herramientas-y-versiones.md](doc/05-herramientas-y-versiones.md) |
| 6. Elementos destacables | [06-elementos-destacables.md](doc/06-elementos-destacables.md) |
| 7. Manual de usuario | [07-manual-de-usuario.md](doc/07-manual-de-usuario.md) |
| 8. Conclusiones | [08-conclusiones.md](doc/08-conclusiones.md) |
| 9. Referencias y bibliografía | [09-referencias-y-bibliografia.md](doc/09-referencias-y-bibliografia.md) |