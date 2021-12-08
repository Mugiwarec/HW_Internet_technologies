package com.mugiwarec.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugiwarec.app.model.Employee;
import com.mugiwarec.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/employee",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
public class EmployeeController {

    private final EmployeeService service;

    private final ObjectMapper mapper;

    @GetMapping("/read/{id}")
    public ResponseEntity<Employee> readEmployeeById(@PathVariable @Positive Long id) {
        return ResponseEntity.of(service.findEmployeeById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @NotNull @RequestBody Employee employee) {
        return ResponseEntity.ok(service.saveEmployee(employee));
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@Valid @NotNull @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.deleteEmployee(id));
    }
}
