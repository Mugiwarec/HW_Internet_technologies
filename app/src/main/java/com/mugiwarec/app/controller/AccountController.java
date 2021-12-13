package com.mugiwarec.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugiwarec.app.model.Account;
import com.mugiwarec.app.service.AccountService;
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
@RequestMapping(value = "/api/v1/account",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
public class AccountController {

    private final AccountService service;

    private final ObjectMapper mapper;

    @GetMapping("/read/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable @Positive Long id) {
        return ResponseEntity.of(service.findAccountById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Account> saveAccount(@Valid @NotNull @RequestBody Account account) {
        return ResponseEntity.ok(service.saveAccount(account));
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@Valid @NotNull @RequestBody Account account) {
        return ResponseEntity.ok(service.updateAccount(account));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.deleteAccount(id));
    }
}
