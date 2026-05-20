package com.company.employee_reporting_system.controller;

import com.company.employee_reporting_system.entity.Employee;
import com.company.employee_reporting_system.service.EmployeeService;
import org.springframework.data.domain.Page;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.company.employee_reporting_system.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@Tag(
        name = "Employee Controller",
        description = "Employee Management APIs"
)
@RestController
@RequestMapping("/employees")


public class EmployeeController {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService service;

    // SAVE EMPLOYEE
    @Operation(summary = "Save employee")
    @PostMapping
    public EmployeeDTO saveEmployee(
            @Valid @RequestBody EmployeeDTO employee) {

        logger.info("Saving employee: {}", employee.getName());

        return service.saveEmployee(employee);
    }

    // GET ALL EMPLOYEES
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {

        logger.info("Fetching all employees");

        return service.getAllEmployees();
    }

    // GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(
            @PathVariable Long id) {

        logger.info("Fetching employee with id: {}", id);

        return service.getEmployeeById(id);
    }
    // UPDATE EMPLOYEE
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        return service.updateEmployee(id, employeeDTO);
    }

    // DELETE EMPLOYEE
    @DeleteMapping("/{id}")
    public void deleteEmployee(
            @PathVariable Long id) {

        logger.warn("Deleting employee with id: {}", id);

        service.deleteEmployee(id);
    }

    // PAGINATION API
    @GetMapping("/pagination")
    public Page<Employee> getEmployeesWithPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return service.getEmployeesWithPagination(page, size, sortBy);
    }
    // SEARCH EMPLOYEE BY NAME
    @GetMapping("/search")
    public List<Employee> searchEmployeeByName(

            @RequestParam String name
    ) {

        return service.searchByName(name);
    }
    // FILTER BY DEPARTMENT
    @GetMapping("/department")
    public List<Employee> getEmployeesByDepartment(

            @RequestParam String department
    ) {

        return service.getEmployeesByDepartment(department);
    }
    // FILTER BY SALARY
    @GetMapping("/salary")
    public List<Employee> getEmployeesBySalary(

            @RequestParam Double minSalary
    ) {

        return service.getEmployeesBySalary(minSalary);
    }

}