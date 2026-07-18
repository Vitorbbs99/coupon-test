# Coupon Management API

API para gerenciamento de cupons de desconto.

---

## Competências utilizadas

- Java 21 & Spring Boot 3
- Spring Data JPA & H2 Database 
- Bean Validation (Jakarta)
- SpringDoc OpenAPI (Swagger)
- JUnit 5 & Mockito
- Docker & Docker Compose.

---

## Arquitetura e Design de Software

- Microsserviços
- Em camadas
- Filosofia Domain-Driven Design (DDD).

---

## Como executar

Certifique-se de ter o Docker instalado e execute: **docker-compose up --build**.

A API estará disponível em: http://localhost:8080

Para explorar e testar os endpoints visualmente, acesse: http://localhost:8080/swagger-ui/index.html

Console H2: 

- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:mydb
- User: sa | Password: password