package org.example.EmployeeManagement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    // Constructor-based dependency injection for JdbcTemplate
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create (Insert) Employee
    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)";

        // Create a KeyHolder to capture the generated id
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Insert the employee and capture the generated id
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());  // Set the first parameter (name)
            ps.setString(2, employee.getRole());  // Set the second parameter (role)
            ps.setDouble(3, employee.getSalary()); // Set the third parameter (salary)
            return ps;
        }, keyHolder);

        // Retrieve the generated id and set it on the employee object
        Number key = keyHolder.getKey();
        if (key != null) {
            employee.setId(key.intValue());  // Set the auto-generated id on the employee object
        }
    }

    // Read (Select) all employees
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getDouble("salary")
        ));
    }

    // Read (Select) employee by ID
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getDouble("salary")
        ), id);
    }

    // Update Employee
    public void updateEmployee(int id, Employee employee) {
        String sql = "UPDATE employee SET name = ?, role = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary(), id);
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}