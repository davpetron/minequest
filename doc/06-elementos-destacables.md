# 6. Elementos destacables del desarrollo

En este apartado se recogen los aspectos más relevantes del desarrollo de MineQuest, incluyendo las decisiones tomadas, los elementos que han supuesto un aprendizaje adicional y las dificultades encontradas durante su implementación.

## 6.1. Aspectos destacables

Uno de los aspectos destacables del proyecto es la aplicación conjunta de Clean Architecture y Vertical Slicing, organizando el código por funcionalidades y separando las responsabilidades de cada capa.

También destaca el uso de MapStruct para facilitar la conversión entre objetos del dominio y DTO, junto con Lombok para reducir código repetitivo.

Otro elemento destacable es la validación personalizada `@TipoTarea`. Las anotaciones estándar no conocen los tipos de tarea de la aplicación, por lo que se ha creado una anotación propia que comprueba que el tipo es uno de los ocho admitidos. Cuando el tipo está vacío, la validación lo da por bueno, porque de ese caso ya se encarga `@NotBlank` y así no se muestra el mismo error dos veces.

Por último, el manejo global de errores con `@ControllerAdvice` permite tratar todas las excepciones en una única clase, situada en el slice `common`, y devolver siempre una página de error con el código HTTP adecuado y un mensaje en español, sin mostrar detalles internos de la aplicación.

## 6.2. Desarrollo de funcionalidades

Se ha desarrollado un sistema de gestión de tareas que permite realizar las operaciones CRUD principales: consultar, crear, modificar y eliminar tareas.

Además, se ha añadido por iniciativa propia la consulta de tareas por prioridad (`GET /tareas/prioridad/{prioridad}`). Esta funcionalidad recorre todas las capas de la arquitectura: un nuevo método en el repositorio, en el caso de uso, en el servicio y en el controlador. Cuando no hay tareas con la prioridad indicada, se reutiliza `TareaNotFoundException` con un nuevo constructor genérico que recibe el campo y el valor buscados, de modo que el manejador global la convierte en un error 404 sin necesidad de modificarlo.

Los datos de entrada se validan antes de llegar a los casos de uso, con mensajes personalizados definidos en el fichero `messages.properties`.

Para la persistencia se ha utilizado una implementación simulada mediante un repositorio en memoria, lo que permite probar el funcionamiento de la aplicación sin depender de una base de datos externa.

## 6.3. Dificultades encontradas

Durante el desarrollo han surgido dificultades relacionadas con la organización de las distintas capas de la arquitectura y la comunicación entre ellas.

También ha sido necesario comprender cómo integrar MapStruct y Lombok dentro de Maven, especialmente en lo relativo al procesamiento de anotaciones y la generación automática de código.

Durante las pruebas se detectó que el manejador genérico de excepciones (`Exception.class`) convertía en un error 500 situaciones que no eran fallos del servidor, como una ruta que no existe (404), un método HTTP no admitido (405) o un identificador que no es un número (400). Se resolvió añadiendo un manejador específico para los parámetros con un tipo incorrecto y respetando, en el manejador genérico, el código HTTP que ya indican las excepciones propias de Spring.

---

[Anterior: Herramientas y versiones](05-herramientas-y-versiones.md) | [Índice](../README.md) | [Siguiente: Manual de usuario](07-manual-de-usuario.md)