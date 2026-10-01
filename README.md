# 📚 Library Management System

A full-stack library management system built with **Spring Boot**, **React**, **Hibernate/JPA**, and **MySQL**. It manages books, authors, publishers, and categories through RESTful APIs and a responsive React frontend.

## 🚀 Features

- Full CRUD operations for books, authors, publishers, and categories
- Search functionality to find books quickly
- RESTful APIs built with Spring Boot
- Responsive React frontend integrated with the backend
- Layered architecture (Controller → Service → Repository)
- Database interaction using JPA/Hibernate
- APIs tested using Postman

## 🛠️ Tech Stack

| Layer        | Technology                  |
|--------------|-----------------------------|
| Frontend     | React                       |
| Backend      | Java, Spring Boot           |
| ORM          | Spring Data JPA / Hibernate |
| Database     | MySQL                       |
| Build Tool   | Maven                       |
| API Testing  | Postman                     |

## 🏗️ Architecture

```
React Frontend → REST APIs (Controller) → Service → Repository → MySQL
```

## ⚙️ Getting Started

### Prerequisites
- JDK 17+ (TODO: check your version in pom.xml)
- Maven
- Node.js and npm
- MySQL

### Backend setup

1. Clone the repository
```bash
   git clone https://github.com/Arun03hub/Library-Management-System.git
   cd Library-Management-System
```

2. Create the database
```sql
   CREATE DATABASE library_db;
```

3. Update `src/main/resources/application.properties` (TODO: fix the path if it's inside LibraryManagementSystem/)
```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/library_db
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
```

4. Run the backend
```bash
   mvn spring-boot:run
```
   Runs at `http://localhost:8080`.

### Frontend setup (TODO: use your real folder name)

```bash
cd frontend
npm install
npm start
```
Runs at `http://localhost:3000`.

## 📡 API Endpoints

(TODO: replace with your real endpoints)

| Method | Endpoint                 | Description          |
|--------|--------------------------|----------------------|
| GET    | `/api/books`             | Get all books        |
| GET    | `/api/books/search`      | Search books         |
| POST   | `/api/books`             | Add a book           |
| PUT    | `/api/books/{id}`        | Update a book        |
| DELETE | `/api/books/{id}`        | Delete a book        |
| GET    | `/api/authors`           | Get all authors      |
| GET    | `/api/publishers`        | Get all publishers   |
| GET    | `/api/categories`        | Get all categories   |

## 👤 Author

**Arun E**
GitHub: [Arun03hub](https://github.com/Arun03hub)
