# Star Wars API

## Introducción

La aplicación proporciona una API para acceder a datos del universo de Star Wars, incluyendo vehículos, naves espaciales, personajes y películas. 

## Requisitos

- Java 8 
- Maven 

## Tecnologías Utilizadas

- Spring Boot
- Spring Security
- Spring Cloud OpenFeign
- Lombok
- Swagger para documentación de API
- JUnit y Mockito para pruebas

### Clonacion del Repositorio

git clone https://github.com/matiassuarez/APIStarWars.git

## Configuracion del Entorno
Intalacion de dependecias:
    Navega a la carpeta del proyecto y ejecuta: ./mvnw install

## Ejecucion de la aplicacion
Navega a la carpeta del proyecto y ejecuta: ./mvnw spring-boot:run

### Acceso a la Aplicacion
La aplicacion estara disponible en http://localhost:8081

Autenticacion:
    Usuario: user
    Password: starwars

### Uso de la Aplicacion
Swagger: La documentacion interactiva de la API esta disponible en http://localhost:8081/swagger-ui.html
         O accediendo desde el boton "Documentacion de Servicios mediante Swagger" en la pagina de inicio

Postman: Descargar coleccion de Postman en http://localhost:8081/postman
         Tambien disponible en la carpeta del proyecto: src/main/resources/postman/postmanexample/StarWars.postman_collection
         O accediendo desde el boton "Descargar proyecto de Postman" en la pagina de inicio

Despliegue en Heroku:
La aplicacion esta desplegada en Heroku y esta disponible en https://starwarsmsuarez-9c82e928c9fa.herokuapp.com/
    
Autenticacion:
    Usuario: user
    Password: starwars

### Pruebas
./mvnw test