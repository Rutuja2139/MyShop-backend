# MyShop | Spring Boot E-Commerce Backend

The robust engine powering the MyShop platform. This API handles product management, user persistence, and secure authentication.

## 🛠️ Tech Stack
- Framework:Spring Boot 3.x
- Language:Java 17+
- Database:MongoDB (Atlas)
- Security: Spring Security with OAuth2 (Google)
- Build Tool: Maven

## 📋 API Endpoints
- `GET /products` - Retrieve all archived hardware.
- `POST /products` - Save a new item to the user's collection.
- `GET /auth/user/info` - Fetch authenticated user details from Google.

## 🚀 Setup Instructions
1. Clone the repository.
2. Create an `application.properties` file in `src/main/resources/` based on the `application.properties.example` template.
3. Add your **MongoDB URI** and **Google OAuth2 Credentials**.
4. Run `./mvnw spring-boot:run`.
