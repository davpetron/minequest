# 6. Elementos destacables del desarrollo

En este apartado se recogen los aspectos más relevantes del desarrollo de MineQuest, incluyendo las decisiones tomadas, los elementos que han supuesto un aprendizaje adicional y las dificultades encontradas durante su implementación.

## 6.1. Aspectos destacables

Uno de los aspectos destacables del proyecto es la aplicación conjunta de Clean Architecture y Vertical Slicing, organizando el código por funcionalidades y separando las responsabilidades de cada capa.

También destaca el uso de MapStruct para facilitar la conversión entre objetos del dominio y DTO, junto con Lombok para reducir código repetitivo.

## 6.2. Desarrollo de funcionalidades

Se ha desarrollado un sistema de gestión de tareas que permite realizar las operaciones CRUD principales: consultar, crear, modificar y eliminar tareas.

Para la persistencia se ha utilizado una implementación simulada mediante un repositorio en memoria, lo que permite probar el funcionamiento de la aplicación sin depender de una base de datos externa.

## 6.3. Dificultades encontradas

Durante el desarrollo han surgido dificultades relacionadas con la organización de las distintas capas de la arquitectura y la comunicación entre ellas.

También ha sido necesario comprender cómo integrar MapStruct y Lombok dentro de Maven, especialmente en lo relativo al procesamiento de anotaciones y la generación automática de código.

[Anterior: Herramientas y versiones](05-herramientas-y-versiones.md) | [Índice](../README.md) | [Siguiente: Manual de usuario](07-manual-de-usuario.md)