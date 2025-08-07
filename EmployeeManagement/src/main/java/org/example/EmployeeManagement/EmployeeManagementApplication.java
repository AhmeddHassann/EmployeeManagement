package org.example.EmployeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }
    @Bean
    public CommandLineRunner createTable(JdbcTemplate jdbcTemplate) {
        return args -> {
            String createTableSql = "CREATE TABLE IF NOT EXISTS employee ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "role VARCHAR(255), "
                    + "salary DOUBLE)";
            jdbcTemplate.execute(createTableSql);
            jdbcTemplate.execute(createTableSql);

            // Insert initial data into the employee table
            String insertDataSql1 = "INSERT INTO employee (name, role, salary) VALUES ('John Doe', 'Manager', 50000)";
            String insertDataSql2 = "INSERT INTO employee (name, role, salary) VALUES ('Jane Smith', 'Developer', 40000)";
            String insertDataSql3 = "INSERT INTO employee (name, role, salary) VALUES ('Alice Johnson', 'HR Manager', 60000)";

            // Execute the insert statements
            jdbcTemplate.update(insertDataSql1);
            jdbcTemplate.update(insertDataSql2);
            jdbcTemplate.update(insertDataSql3);
        };

    }

}
