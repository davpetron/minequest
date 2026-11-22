# 3. Implementación

## 3.1. Entorno de desarrollo

MineQuest se desarrolla utilizando Java y Spring Boot, junto con diferentes herramientas y bibliotecas que facilitan la implementación y organización del código.

### 3.1.1. Lenguaje y framework

- **Java 17:** lenguaje de programación utilizado para desarrollar la aplicación.
- **Spring Boot 4.1.2:** framework utilizado para crear y ejecutar la aplicación web.

### 3.1.2. Gestión del proyecto y dependencias

El proyecto utiliza **Maven** como herramienta de gestión de dependencias y construcción. La configuración se encuentra en el archivo `pom.xml`, donde se definen las bibliotecas y los plugins necesarios.

Entre las principales dependencias utilizadas se encuentran:

| Dependencia | Finalidad |
|---|---|
| Spring Boot Starter WebMVC | Desarrollo de la aplicación web y gestión de peticiones HTTP. |
| Spring Boot Starter Validation	| Validación de datos de entrada. |
| Lombok | Reducción de código repetitivo mediante anotaciones. |
| MapStruct | Conversión entre objetos, como modelos y DTO. |
| Lombok-MapStruct Binding | Facilita la integración entre Lombok y MapStruct. |
| MapStruct Processor | Generación automática de las implementaciones de los mappers. |

El proyecto también incluye el Maven Wrapper, que permite utilizar Maven mediante los archivos `mvnw` y `mvnw.cmd`.

### 3.1.3. Entorno de desarrollo

Para desarrollar la aplicación se utiliza **Visual Studio Code** como entorno de desarrollo, sobre una máquina virtual con **Debian 13**. Las pruebas se realizan desde la terminal con el comando **curl** y desde el navegador.

### 3.1.4. Control de versiones

Utilizamos **Git** para gestionar las diferentes versiones del código durante el desarrollo.

El proyecto se encuentra alojado en **GitHub**, lo que nos permite mantener un repositorio compartido y trabajar conjuntamente.

Para organizar el trabajo utilizamos **GitFlow**, un flujo de trabajo basado en ramas que permite separar el desarrollo de nuevas funcionalidades de las versiones principales del proyecto.

### 3.1.5. Arquitectura y organización del código

La aplicación sigue los principios de Clean Architecture y utiliza Vertical Slicing para organizar el código por funcionalidades.

El proyecto contempla dos slices principales:

- **tarea:** contiene la funcionalidad relacionada con la gestión de tareas.
- **common:** agrupa los elementos compartidos por las distintas funcionalidades.

### 3.1.6. Recursos web

La aplicación incluye un formulario HTML estático para facilitar la creación de tareas. Este recurso se encuentra dentro de `src/main/resources/static/` y se sirve desde la propia aplicación.

En `src/main/resources/` se encuentra también el fichero `messages.properties`, que contiene los mensajes personalizados de las validaciones.

### 3.1.7. Documentación
La documentación del proyecto se realiza mediante ficheros Markdown (.md), organizados dentro de la carpeta doc/.

Además, utilizamos un fichero README.md en la raíz del repositorio para presentar el proyecto y facilitar la navegación por los diferentes documentos.

## 3.2. Implantación y puesta en producción

Actualmente, MineQuest está preparada para ejecutarse en un entorno local mediante Spring Boot, sin que se haya realizado un despliegue en un entorno de producción.

---

[Anterior: Diseño](02-diseno.md) | [Índice](../README.md) | [Siguiente: Ejecución y pruebas](04-ejecucion-y-pruebas.md)