package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.EmployeeMapper;
import com.mugiwarec.app.model.Employee;
import com.mugiwarec.app.service.EmployeeService;
import com.mugiwarec.core.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return repository.findById(id).map(EmployeeMapper.MAPPER::toEmployee);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public String deleteEmployee(Long id) {
        return null;
    }
}
