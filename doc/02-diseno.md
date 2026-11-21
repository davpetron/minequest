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
    │       └── web/mvc/
    │           ├── controller/
    │           │   └── TareaController.java
    │           └── dto/
    │               ├── TareaRequest.java
    │               └── TareaResponse.java
    │
    └── common/
        └── infraestructure/
            └── web/
                └── error/
                    ├── CustomResponse.java
                    └── GlobalExceptionHandler.java
```

Actualmente, los datos de las tareas se almacenan en memoria mediante una implementación mock del repositorio que utiliza un `LinkedHashMap`, por lo que no se emplea una base de datos externa.

## 2.3. Gestión de errores y excepciones

La aplicación cuenta con excepciones propias para gestionar situaciones en las que no se encuentra una tarea.

Se han definido las siguientes clases:

- **EntityNotFoundException:** excepción general para indicar que una entidad no ha sido encontrada.
- **TareaNotFoundException:** especialización de la anterior para los casos en los que no se encuentra una tarea.

Por ejemplo, cuando se intenta consultar una tarea mediante un identificador que no existe, se lanza una `TareaNotFoundException`.

También se utiliza esta excepción cuando el listado de tareas está vacío.

## 2.4. Plan de pruebas

Las pruebas se realizan de forma manual, ejecutando la aplicación en local y utilizando el navegador y el comando `curl` desde la terminal.

El plan incluye tanto casos en los que la aplicación debe funcionar correctamente como casos de error, para comprobar el comportamiento de las operaciones y el manejo de excepciones.

| **Id** | **Prueba** | **Herramienta** | **Resultado esperado** |
| ------ | ----------------------------------- | --------------- | --------------------------------------------- |
| P01 | Arranque de la aplicación | Terminal | La aplicación arranca correctamente en el puerto 8080 |
| P02 | Listado de tareas | Navegador | Se obtiene el listado de tareas en formato JSON |
| P03 | Creación de una tarea | Formulario | Se crea la tarea y se muestran sus datos |
| P04 | Listado tras crear | Navegador | La nueva tarea aparece en el listado |
| P05 | Modificación de una tarea | curl | Código 200 y datos actualizados |
| P06 | Eliminación de una tarea | curl | Código 204 |
| P07 | Listado tras eliminar | Navegador | La tarea eliminada no aparece en el listado |
| P08 | Consulta de una tarea inexistente | curl | Se gestiona la excepción de tarea no encontrada |
| P09 | Modificación de una tarea inexistente | curl | Se gestiona la excepción de tarea no encontrada |
| P10 | Eliminación de una tarea inexistente | curl | Se gestiona la excepción de tarea no encontrada |

---

[Anterior: Contexto de la aplicación](01-contexto.md) | [Índice](../README.md) | [Siguiente: Implementación](03-implementacion.md)