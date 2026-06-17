package com.example.jasperimplementation.repository;

import com.example.jasperimplementation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
