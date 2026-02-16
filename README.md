# MyShop | Enterprise Spring Boot E-Commerce Backend

A high-performance backend engine built for the MyShop platform. This API provides a robust architecture for product lifecycle management, relational user persistence, and secure OAuth2 authentication.

## 🛠️ Tech Stack
- **Framework:** Spring Boot 3.x
- **Language:** Java 17+
- **Database:** MySQL 8.0 (Migrated for Relational Integrity & ACID Compliance)
- **ORM:** Spring Data JPA / Hibernate
- **Security:** Spring Security with OAuth2 (Google Login)
- **Build Tool:** Maven

## 📋 API Endpoints
- `GET /products` - Retrieve all inventory items.
- `POST /products` - Persist a new product to the relational database.
- `DELETE /products/{id}` - Remove a product entry by unique Long ID.
- `GET /auth/user/info` - Fetch authenticated user session details via Google OAuth2.

## 🚀 Setup Instructions
1. **Clone the repository.**
2. **Database Setup:** Ensure a MySQL instance is running and create the schema:
   `CREATE DATABASE ecommerce;`
3. **Configuration:** Update `src/main/resources/application.properties` with your MySQL credentials and Google OAuth2 Client ID/Secret.
4. **Hibernate DDL:** The system is configured with `hibernate.ddl-auto=update` to automatically generate table structures.
5. **Run:** Execute `./mvnw spring-boot:run`.
