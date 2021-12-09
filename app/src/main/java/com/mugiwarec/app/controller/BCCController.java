package com.mugiwarec.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugiwarec.app.model.BCC;
import com.mugiwarec.app.service.BCCService;
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
@RequestMapping(value = "/api/v1/bcc",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
public class BCCController {

    private final BCCService service;

    private final ObjectMapper mapper;

    @GetMapping("/read/{id}")
    public ResponseEntity<BCC> readBCCById(@PathVariable @Positive Long id) {
        return ResponseEntity.of(service.findBCCById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<BCC> createBCC(@Valid @NotNull @RequestBody BCC bcc) {
        return ResponseEntity.ok(service.saveBCC(bcc));
    }

    @PutMapping("/update")
    public ResponseEntity<BCC> updateBCC(@Valid @NotNull @RequestBody BCC bcc) {
        return ResponseEntity.ok(service.updateBCC(bcc));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBCC(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.deleteBCC(id));
    }
}
