# 📚 Inventory Management System

## 📝 Description
This is a Inventory Management System that exposes a REST API to manage a inventory. It's a great starting point for learning about Spring Boot, REST APIs, and database integration.
## 📋 Requirements

- ☕ Java 17
- 🏗️ Maven
- 🐳 Docker
- 🧩 Docker-compose
- 📬 Postman

## 🚀 How to Run

### ▶️ Run the Application Locally
To run the application directly on your machine, use the following Maven command:
```shell
mvn spring-boot:run
```
Create jar file
```shell
mvn clean package -DskipTests
```

### 🐳 Run the Application with Docker-compose

This application uses MySQL as the backend database. To run the application along with MySQL in Docker containers, use the following command:
```shell
docker-compose up -d
```
