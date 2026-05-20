package com.company.employee_reporting_system.repository;

import com.company.employee_reporting_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    // SEARCH BY NAME
    List<Employee> findByNameContainingIgnoreCase(String name);

    // FILTER BY DEPARTMENT
    List<Employee> findByDepartmentIgnoreCase(String department);

    // FILTER BY SALARY GREATER THAN
    List<Employee> findBySalaryGreaterThanEqual(Double salary);
}