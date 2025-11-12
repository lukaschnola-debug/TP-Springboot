# TP - API REST de Gestión de Productos

API REST completa desarrollada con Spring Boot para la gestión de productos (CRUD), como parte del Trabajo Práctico de la materia Programación III.

## 🚀 Tecnologías Utilizadas

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Web:** Para crear los endpoints REST.
* **Spring Data JPA:** Para la persistencia de datos.
* **H2 Database:** Base de datos en memoria.
* **Validation:** Para validar los DTOs.
* **Lombok:** Para reducir código boilerplate.
* **Springdoc OpenAPI (Swagger):** Para la documentación de la API.

## 🛠️ Instrucciones para Ejecutar

1.  Clonar este repositorio:
    ```bash
    git clone [https://github.com/TU_USUARIO/dproductos-api.git](https://github.com/TU_USUARIO/dproductos-api.git)
    ```
2.  Navegar a la carpeta del proyecto:
    ```bash
    cd dproductos-api
    ```
3.  Ejecutar el proyecto con Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

## 🔑 Endpoints Clave

La aplicación estará corriendo en `http://localhost:8080`.

| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/productos` | Lista todos los productos. |
| `GET` | `/api/productos/{id}` | Obtiene un producto por su ID. |
| `GET` | `/api/productos/categoria/{categoria}` | Filtra productos por categoría. |
| `POST` | `/api/productos` | Crea un nuevo producto. |
| `PUT` | `/api/productos/{id}` | Actualiza un producto completo. |
| `PATCH`| `/api/productos/{id}/stock` | Actualiza solo el stock. |
| `DELETE`| `/api/productos/{id}` | Elimina un producto. |

## 🌐 Acceso a Herramientas

* **Documentación Swagger (Probar API):**
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

* **Consola H2 (Ver Base de Datos):**
  [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    * **JDBC URL:** `jdbc:h2:mem:testdb`
    * (Dejar usuario y contraseña vacíos)

---
* **Nombre:** (Poné tu nombre)
* **Legajo:** (Poné tu legajo)