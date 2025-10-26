# Solicitudes de Soporte Técnico - API RESTful (Spring Boot)

## 📝 Descripción del Proyecto

Este proyecto es una API RESTful desarrollada con *Spring Boot 3* y *Java 21* para la *Gestión de Solicitudes de Soporte TEcnico*. El objetivo es reemplazar el registro manual de problemas, permitiendo a los clientes registrar, consultar y gestionar el ciclo de vida de una solicitud (CRUD).

La aplicación simula el almacenamiento de datos *en memoria* (Hasmap), cumpliendo con la arquitectura de capas y aplicando validaciones estrictas.

## ⚙️ Arquitectura de Capas

El proyecto está organizado en una arquitectura de tres capas principales más la capa de manejo de errores:

1.  **`model`**: Define las entidades de negocio: `Solicitud`, `Cliente`, y `Tecnico`. Contiene las **validaciones de entrada** (@NotBlank, @Min).
2.  **`service`**: Contiene la lógica de negocio y la **simulación de persistencia** (repositorio en memoria), asegurando el correcto flujo de datos y el manejo de excepciones.
3.  **`controller`**: Expone los **endpoints RESTful** y se encarga de recibir las peticiones HTTP y devolver las respuestas con los códigos de estado apropiados.
4.  **`exception`**: Contiene el **`GlobalExceptionHandler`** para uniformizar las respuestas de error (`400`, `404`).

## 🚀 Instalación y Ejecución

### Requisitos Previos

* **Java Development Kit (JDK) 21** o superior.
* **Apache Maven**.
* **Cliente REST** (Postman/cURL/VS Code Extensión) para pruebas.

### Pasos para Ejecutar

1.  **Navegar al Proyecto:**
    ```bash
    cd soporte_tecnico
    ```
2.  **Compilar y Ejecutar Spring Boot:**
    ```bash
    mvn spring-boot:run
    ```
    La aplicación se iniciará en `http://localhost:8080`.

## 📌 Endpoints de la API (CRUD)

La ruta base para todas las peticiones es `/api/solicitudes`.

| Operación | Método | Ruta | Descripción | Body (JSON) | Códigos HTTP |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Registrar** | `POST` | `/api/solicitudes` | Crea y registra una nueva solicitud de soporte. | **Requerido** (con `titulo`, `descripcion`, `cliente`, `prioridad`) | **201 Created**, **400 Bad Request** |
| **Consultar Todas** | `GET` | `/api/solicitudes` | Lista todas las solicitudes activas. | No requiere | **200 OK** |
| **Consultar por ID** | `GET` | `/api/solicitudes/{id}` | Obtiene los detalles de una solicitud específica. | No requiere | **200 OK**, **404 Not Found** |
| **Actualizar** | `PUT` | `/api/solicitudes/{id}` | Actualiza completamente el estado o detalles de la solicitud. | **Requerido** | **200 OK**, **404 Not Found** |
| **Eliminar** | `DELETE` | `/api/solicitudes/{id}` | Elimina una solicitud del registro. | No requiere | **204 No Content**, **404 Not Found** |