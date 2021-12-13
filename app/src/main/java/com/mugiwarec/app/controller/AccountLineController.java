package com.mugiwarec.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugiwarec.app.model.AccountLine;
import com.mugiwarec.app.service.AccountLineService;
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
@RequestMapping(value = "/api/v1/account_line",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
public class AccountLineController {

    private final AccountLineService service;

    private final ObjectMapper mapper;

    @GetMapping("/read/{id}")
    public ResponseEntity<AccountLine> findAccountLineById(@PathVariable @Positive Long id) {
        return ResponseEntity.of(service.findAccountLineById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountLine> saveAccountLine(@Valid @NotNull @RequestBody AccountLine accountLine) {
        return ResponseEntity.ok(service.saveAccountLine(accountLine));
    }

    @PutMapping("/update")
    public ResponseEntity<AccountLine> updateAccountLine(@Valid @NotNull @RequestBody AccountLine accountLine) {
        return ResponseEntity.ok(service.updateAccountLine(accountLine));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccountLine(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.deleteAccountLine(id));
    }
}
