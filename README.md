# Puck Spring Boot & H2 DB demo

## Deployment

- git pull https://github.com/tahaburak/puck-spring-boot-h2.git
- mvn clean install
- java -jar -Djasypt.encryptor.password=deneme12 target/puck-spring-boot-h2-exec.jar

### Data

#### Json-Server
Requires nodeJS
- [download installer x64](https://nodejs.org/en/download/) 
- control with node -v and npm -v
- npm config set strict-ssl false
* npm install -g json-server
* json-server --watch src/main/resources/database/users.json
* Visit http://localhost:3000/ or http://localhost:3000/users

#### H2

Visit http://localhost:7777/h2-console/

- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:file:./src/main/resources/database/db
- UN: test
- PW: sa

### GUI
* [Swagger UI](http://localhost:7777/swagger-ui.html)
* [Import to Postman](src/main/resources/postman)

### FYI

If json-server is running will be used as main source, else H2 DB. If H2 fails (no Users table) dummy service will generate users.

If H2 fails call refresh http://localhost:7777/h2/refresh/users


## Tools & Libraries

- https://start.spring.io/
- https://www.h2database.com/
- https://projectlombok.org/
- https://swagger.io/docs/specification/2-0/basic-structure/
- https://github.com/ulisesbocchio/jasypt-spring-boot (ENCRYPTION)
- https://github.com/DiUS/java-faker