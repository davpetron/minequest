# 2. Diseño

## 2.1. Arquitectura

MineQuest sigue una arquitectura basada en **Clean Architecture**, cuyo objetivo es separar las responsabilidades de la aplicación y facilitar su mantenimiento y evolución.

Además, se utiliza el enfoque de **Vertical Slicing**, organizando el proyecto por funcionalidades. De esta forma, cada funcionalidad agrupa los elementos necesarios para su funcionamiento.

La aplicación se organiza en dos slices principales:

- **tarea:** contiene la funcionalidad relacionada con la gestión de tareas de Minecraft.
- **common:** agrupa los elementos compartidos que pueden ser utilizados por diferentes funcionalidades.

Dentro del slice `tarea`, el código se divide en tres capas principales siguiendo **Clean Architecture**:

- **domain:** contiene los modelos de dominio, las interfaces de los repositorios y las excepciones propias de la funcionalidad.
- **application:** contiene los comandos, servicios y casos de uso que implementan las operaciones de la aplicación.
- **infraestructure:** contiene los elementos relacionados con la interacción externa, como los controladores, DTO, mappers y la implementación del repositorio.

Esta separación permite mantener diferenciadas las reglas de negocio, los casos de uso y los detalles de infraestructura.

## 2.2. Organización del código

La estructura principal del proyecto es la siguiente:

```text
minequest/
└── src/main/java/es/etg/daw/dwes/minequest/
    ├── MinequestApplication.java
    │
    ├── tarea/
    │   ├── application/
    │   │   ├── command/
    │   │   │   ├── CreateTareaCommand.java
    │   │   │   └── EditTareaCommand.java
    │   │   ├── service/
    │   │   │   ├── CreateTareaService.java
    │   │   │   ├── DeleteTareaService.java
    │   │   │   ├── EditTareaService.java
    │   │   │   └── FindTareaService.java
    │   │   └── usecase/
    │   │       ├── CreateTareaUseCase.java
    │   │       ├── DeleteTareaUseCase.java
    │   │       ├── EditTareaUseCase.java
    │   │       └── FindTareaUseCase.java
    │   │
    │   ├── domain/
    │   │   ├── error/
    │   │   │   ├── EntityNotFoundException.java
    │   │   │   └── TareaNotFoundException.java
    │   │   ├── model/
    │   │   │   └── Tarea.java
    │   │   └── repository/
    │   │       ├── CRUDRepository.java
    │   │       └── TareaRepository.java
    │   │
    │   └── infraestructure/
    │       ├── config/
    │       │   └── TareaConfig.java
    │       ├── db/
    │       │   └── repository/mock/
    │       │       ├── TareaFactory.java
    │       │       └── TareaRepositoryMockImpl.java
    │       ├── mapper/
    │       │   └── TareaMapper.java
    │       └── web/
    │           ├── mvc/
    │           │   ├── controller/
    │           │   │   └── TareaController.java
    │           │   └── dto/
    │           │       ├── TareaRequest.java
    │           │       └── TareaResponse.java
    │           └── validation/
    │               ├── TipoTarea.java
    │               └── TipoTareaValidator.java
    │
    └── common/
        └── infraestructure/
            └── web/
                └── error/
                    ├── CustomResponse.java
                    └── GlobalExceptionHandler.java
```

Además, en `src/main/resources/` se encuentran `application.properties`, `messages.properties` (mensajes de validación) y el formulario `static/formulario-crear-tarea.html`.

Actualmente, los datos de las tareas se almacenan en memoria mediante una implementación mock del repositorio que utiliza un `LinkedHashMap`, por lo que no se emplea una base de datos externa.

## 2.3. Gestión de errores y excepciones

La aplicación cuenta con excepciones propias para gestionar situaciones en las que no se encuentra una tarea.

Se han definido las siguientes clases:

- **EntityNotFoundException:** excepción general para indicar que una entidad no ha sido encontrada.
- **TareaNotFoundException:** especialización de la anterior para los casos en los que no se encuentra una tarea.

Por ejemplo, cuando se intenta modificar o eliminar una tarea mediante un identificador que no existe, se lanza una `TareaNotFoundException`.

También se utiliza esta excepción cuando el listado de tareas está vacío y cuando no hay tareas con la prioridad indicada.

Todas las excepciones se gestionan de forma global en la clase `GlobalExceptionHandler`, anotada con `@ControllerAdvice`, que devuelve una página de error con la fecha, el código HTTP y el mensaje:

| Situación | Código | Mensaje |
|---|---|---|
| Datos no válidos | 400 | Los de `messages.properties` |
| Parámetro de ruta que no es un número | 400 | "El parámetro id debe ser un número" |
| Tarea no encontrada o prioridad sin tareas | 404 | "tarea con id 99 no encontrada", "No hay tareas con prioridad 1" |
| Ruta que no existe | 404 | "La ruta solicitada no existe" |
| Error no previsto | 500 | "Error interno del servidor" |

## 2.4. Validación de datos

Los datos de entrada se validan en el DTO `TareaRequest` mediante anotaciones, que se activan con `@Valid` en los métodos de crear y modificar del controlador:

- **nombre:** obligatorio (`@NotBlank`) y de 100 caracteres como máximo (`@Size`).
- **descripcion:** de 255 caracteres como máximo (`@Size`).
- **tipo:** obligatorio (`@NotBlank`) y uno de los ocho tipos admitidos (`@TipoTarea`).
- **prioridad:** entre 1 y 5 (`@Min` y `@Max`).

`@TipoTarea` es una validación personalizada, implementada en `TipoTareaValidator`, ya que ninguna anotación estándar conoce los tipos de tarea de la aplicación.

Los mensajes de error de las validaciones se definen en el fichero `messages.properties`.

## 2.5. Plan de pruebas

Las pruebas se realizan de forma manual, ejecutando la aplicación en local y utilizando el navegador y el comando `curl` desde la terminal.

El plan incluye tanto casos en los que la aplicación debe funcionar correctamente como casos de error, para comprobar el comportamiento de las operaciones y el manejo de excepciones.

| **Id** | **Prueba** | **Herramienta** | **Resultado esperado** |
| ------ | ----------------------------------- | --------------- | --------------------------------------------- |
| P01 | Arranque de la aplicación | Terminal | La aplicación arranca correctamente en el puerto 8080 |
| P02 | Listado de tareas | Navegador | Se obtiene el listado de tareas en formato JSON |
| P03 | Creación de una tarea | Formulario | Se crea la tarea y se muestran sus datos |
| P04 | Listado tras crear | Navegador | La nueva tarea aparece en el listado |
| P05 | Modificación de una tarea | curl | Código 200 y datos actualizados |
| P06 | Listado por prioridad | curl | Código 200 y solo las tareas con esa prioridad |
| P07 | Eliminación de una tarea | curl | Código 204 |
| P08 | Listado tras eliminar | Navegador | La tarea eliminada no aparece en el listado |
| P09 | Validaciones estándar | curl | Código 400 con los errores de nombre y prioridad |
| P10 | Validación personalizada del tipo | curl | Código 400 con el mensaje de tipo no válido |
| P11 | Eliminación de una tarea inexistente | curl | Código 404 y mensaje de tarea no encontrada |
| P12 | Listado por una prioridad sin tareas | curl | Código 404 y mensaje "No hay tareas con prioridad 1" |
| P13 | Parámetro de ruta incorrecto | curl | Código 400 y mensaje "El parámetro id debe ser un número" |

---

[Anterior: Contexto de la aplicación](01-contexto.md) | [Índice](../README.md) | [Siguiente: Implementación](03-implementacion.md)