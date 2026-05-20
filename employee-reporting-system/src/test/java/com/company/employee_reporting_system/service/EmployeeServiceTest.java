package com.company.employee_reporting_system.service;

import com.company.employee_reporting_system.dto.EmployeeDTO;
import com.company.employee_reporting_system.entity.Employee;
import com.company.employee_reporting_system.repository.EmployeeRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;
    @Spy
    private ModelMapper modelMapper = new ModelMapper();
    @InjectMocks
    private EmployeeService service;

    @Test
    void testGetAllEmployees() {

        // ENTITY OBJECTS
        Employee e1 = new Employee();
        e1.setId(1L);
        e1.setName("Manohar");

        Employee e2 = new Employee();
        e2.setId(2L);
        e2.setName("Kumar");

        // MOCK REPOSITORY
        when(repository.findAll())
                .thenReturn(Arrays.asList(e1, e2));

        // CALL REAL SERVICE METHOD
        List<EmployeeDTO> employees =
                service.getAllEmployees();

        // VERIFY RESULT
        assertEquals(2, employees.size());
    }
}