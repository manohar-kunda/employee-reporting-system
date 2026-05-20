package com.company.employee_reporting_system.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String message) {

        super(message);
    }
}