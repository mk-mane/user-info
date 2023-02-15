# Code Challenge 

**Problem :**
Create a spring-boot microservice that will accept 5 input parameters (Name, SSN, Phone, Email & BirthDate). The service should validate input parameters using minimalist coding (use annotations as much as possible). Then make 3 dummy calls to 3 back-end services (SSN Validation, Phone Validation and Email Validation) using multi-threading or asynchronous calls If all 3 are successful, store the entire object in a DB and create a unique CustomerID and send back to calling client

### Tech Stack

Java, Spring Boot, Spring Data JPA,H2 database and Swagger

## Development server

`http://localhost:8080/`. is the default port number for spring boot app.

```sh
View for Valid Request and Response in Swagger
```
![Valid request and valid response with automatic generated customerld](https://user-images.githubusercontent.com/123708251/219126656-353bc961-230c-4c19-b0d0-25c2cb9ec8df.jpeg)


```sh
View for InValid Request and with Response in Swagger
```
![Invalid email with error](https://user-images.githubusercontent.com/123708251/219126858-c8b9cc21-78c0-48a6-aa95-69a86e2e5bc3.jpeg)

