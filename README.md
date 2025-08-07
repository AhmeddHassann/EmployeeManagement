# EmployeeManagement# Employee Management System

This is a simple **Employee Management System** built using **Spring Boot** and **JdbcTemplate** for database interaction.
The application allows you to perform basic **CRUD operations** (Create, Read, Update, Delete) on employee records.

---

## Technologies Used

- **Java 17+**
  - **Spring Boot**
  - **JdbcTemplate** (for database interaction)
  - **H2** (In-memory Database)
  - **Postman** (for API testing)

---

API Endpoints
You can test the following endpoints using Postman
1. GET /employees
Purpose: Retrieves a list of all employees.
Request: GET http://localhost:8080/employees

2. GET /employees/{id}
Purpose: Retrieves a specific employee by their id.
Request: GET http://localhost:8080/employees/{id}
(Replace {id} with the employee's id

3. DELETE /employees/{id}
Purpose: Deletes an employee by their id.
Request: DELETE http://localhost:8080/employees/{id}
(Replace {id} with the employee's id

4. POST /employees
Purpose: Creates a new employee.
Request: POST http://localhost:8080/employees

5. PUT /employees/{id}
Purpose: Updates an existing employee by their id.
Request: PUT http://localhost:8080/employees/{id}
(Replace {id} with the employee's id


