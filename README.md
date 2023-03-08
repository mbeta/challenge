# Desafio API REST

Servicio para consulta de precio final dada una fecha de aplicacion.

**Módulos**
- Domain
- Service

**Características**

- Spring Boot 2.2.0
- Maven
- Java 11
- Base de Datos H2
- Flyway

**Ejecución**
Tener en cuenta que se debe ejecutar proyecto con profile "develop"

1. Clonar repositorio
2. Dirigirse a directorio /service 
3. Ejecular comando: mvn spring-boot:run "-Dspring-boot.run.profiles=develop"



Ejecutar petición:
- Collection de postman en /docs

```
curl --location --request GET 'http://localhost:8080/challenge-precios-api/precios' \
--form 'fechaAplicacion="2020-06-14T21:00"' \
--form 'idProducto="35455"' \
--form 'idMarca="1"'
```
