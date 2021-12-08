package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.EmployeeMapper;
import com.mugiwarec.app.model.Employee;
import com.mugiwarec.app.service.EmployeeService;
import com.mugiwarec.core.entity.EmployeeEntity;
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
        EmployeeEntity entity = repository.saveAndFlush(EmployeeMapper.MAPPER.toEmployeeEntity(employee));

        return EmployeeMapper.MAPPER.toEmployee(entity);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<EmployeeEntity> entity = repository.findById(employee.getId());

        if (entity.isPresent()) {
            repository.saveAndFlush(EmployeeMapper.MAPPER.toEmployeeEntity(employee));
        } else {
            throw new RuntimeException("Employee not Found");
        }

        return employee;
    }

    @Override
    public String deleteEmployee(Long id) {
        Optional<EmployeeEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not Found");
        }

        return "Employee was deleted";
    }
}
