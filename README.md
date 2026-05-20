# Employee Reporting System

A Spring Boot backend application for managing employees with JWT Authentication, PostgreSQL database integration, Swagger API documentation, validation, exception handling, pagination, filtering, and logging.

## Features

- Employee CRUD Operations
- JWT Authentication & Authorization
- Spring Security Integration
- PostgreSQL Database
- Global Exception Handling
- Input Validation
- Pagination & Sorting
- Search & Filtering APIs
- Swagger/OpenAPI Documentation
- Logging with SLF4J & Logback
- Unit Testing with JUnit & Mockito
- RESTful APIs

 ## Technologies Used

- Java 17
- Spring Boot 3.5
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (JSON Web Token)
- Maven
- Swagger/OpenAPI
- JUnit 5
- Mockito
- Logback
- IntelliJ IDEA

## Project Structure

```text
src/main/java
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── exception
 └── config
```
## API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | `/auth/login` | Generate JWT Token |

---

### Employee APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| POST | `/employees` | Create employee |
| PUT | `/employees/{id}` | Update employee |
| DELETE | `/employees/{id}` | Delete employee |
| GET | `/employees/search?name=` | Search employee |
| GET | `/employees/department?department=` | Filter by department |
| GET | `/employees/salary?minSalary=` | Filter by salary |
| GET | `/employees/pagination?page=0&size=5&sortBy=id` | Pagination |

## Security

This project uses:

- Spring Security
- JWT Authentication
- Stateless Authentication
- Password Encryption using BCryptPasswordEncoder

## Swagger Documentation

After running the project:

http://localhost:8080/swagger-ui/index.html

  ## Database

- PostgreSQL
- Spring Data JPA
- Hibernate ORM
  ## How to Run the Project

### Clone Repository

```bash
git clone https://github.com/manohar-kunda/employee-reporting-system.git
```

### Navigate to Project

```bash
cd employee-reporting-system
```

### Run Application

```bash
mvn spring-boot:run
```

### Open Swagger

```text
http://localhost:8080/swagger-ui/index.html
```

## Future Enhancements

- Docker Integration
- CI/CD Pipeline
- Cloud Deployment
- Role-Based Access Control
- Email Notifications
- Report Generation
- Microservices Architecture
  
  ## Author

Manohar Kunda

- MCA Student
- Java Backend Developer
- Spring Boot Enthusiast
