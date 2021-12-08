package com.mugiwarec.app.service;

import com.mugiwarec.app.model.Employee;

import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    String deleteEmployee(Long id);
}
