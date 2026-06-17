package com.example.jasperimplementation.repository;


import com.example.jasperimplementation.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void testSaveEmployee() {

        Employee employee = new Employee();

        employee.setId(101);
        employee.setName("Rushi");
        employee.setDepartment("IT");
        employee.setSalary(50000.0);

        Employee saved =
                repository.save(employee);

        assertNotNull(saved);
        assertEquals("Rushi",
                saved.getName());
    }
}