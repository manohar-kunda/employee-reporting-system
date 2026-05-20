package com.company.employee_reporting_system.service;

import com.company.employee_reporting_system.entity.Employee;
import com.company.employee_reporting_system.exception.ResourceNotFoundException;
import com.company.employee_reporting_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.company.employee_reporting_system.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    // SAVE EMPLOYEE
    public EmployeeDTO saveEmployee(EmployeeDTO dto) {

        Employee employee =
                modelMapper.map(dto, Employee.class);

        Employee savedEmployee =
                repository.save(employee);

        return modelMapper.map(
                savedEmployee,
                EmployeeDTO.class
        );
    }

    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees =
                repository.findAll();

        return employees.stream()
                .map(employee ->
                        modelMapper.map(
                                employee,
                                EmployeeDTO.class
                        )
                )
                .toList();
    }
    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with ID: " + id
                        )
                );

        return modelMapper.map(
                employee,
                EmployeeDTO.class
        );
    }
    public EmployeeDTO updateEmployee(
            Long id,
            EmployeeDTO dto) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with ID: " + id
                        )
                );

        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        Employee updatedEmployee =
                repository.save(employee);

        return modelMapper.map(
                updatedEmployee,
                EmployeeDTO.class
        );
    }
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
    //pagination
    public Page<Employee> getEmployeesWithPagination(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy)
        );

        return repository.findAll(pageable);
    }

    // SEARCH BY NAME
    public List<Employee> searchByName(String name) {

        return repository.findByNameContainingIgnoreCase(name);
    }
    // FILTER BY DEPARTMENT
    public List<Employee> getEmployeesByDepartment(
            String department
    ) {

        return repository.findByDepartmentIgnoreCase(department);
    }
    // FILTER BY MINIMUM SALARY
    public List<Employee> getEmployeesBySalary(
            Double minSalary
    ) {

        return repository.findBySalaryGreaterThanEqual(minSalary);
    }
}