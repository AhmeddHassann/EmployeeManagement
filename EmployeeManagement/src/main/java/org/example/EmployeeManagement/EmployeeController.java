package org.example.EmployeeManagement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    // Injecting the EmployeeRepository (handles DB CRUD operations)
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // GET /employees - Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();  // Fetch employees from H2 database
    }

    // GET /employees/{id} - Get a specific employee by id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.getEmployeeById(id);  // Fetch employee by ID from DB
    }

    // POST /employees - Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employeeRepository.createEmployee(employee);  // Insert employee into the H2 database
        return employee;
    }

    // PUT /employees/{id} - Update an existing employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeRepository.updateEmployee(id, employee);  // Update employee in the H2 DB
        return employee;
    }

    // DELETE /employees/{id} - Delete an employee by id
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteEmployee(id);  // Delete employee from the H2 database
        return "Employee deleted successfully!";
    }
}