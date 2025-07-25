# 🛠️ Instrucciones para correr toda la aplicación

## 1. Base de Datos Oracle

- Instalar Oracle Database XE 21c: https://www.oracle.com/database/technologies/xe-downloads.html
- Crear el usuario `comercio` en el contenedor `XEPDB1`
- Ejecutar los scripts en `/plsql` en orden:
  - `01_create_tables.sql` hasta `05_package_comerciantes.sql`

## 2. Backend Spring Boot

- Clonar el repo
- Configurar `application.properties` con los datos de la DB
- Ejecutar: `./mvnw spring-boot:run`
