package com.mugiwarec.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugiwarec.app.model.OverLimit;
import com.mugiwarec.app.service.OverLimitService;
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
@RequestMapping(value = "/api/v1/over_limit",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
public class OverLimitController {

    private final OverLimitService service;

    private final ObjectMapper mapper;

    @GetMapping("/read/{id}")
    public ResponseEntity<OverLimit> readOverLimitById(@PathVariable @Positive Long id) {
        return ResponseEntity.of(service.findOverLimitById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<OverLimit> createOverlimit(@Valid @NotNull @RequestBody OverLimit overLimit) {
        return ResponseEntity.ok(service.saveOverLimit(overLimit));
    }

    @PutMapping("/update")
    public ResponseEntity<OverLimit> updateOverLimit(@Valid @NotNull @RequestBody OverLimit overLimit) {
        return ResponseEntity.ok(service.updateOverLimit(overLimit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOverLimit(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.deleteOverLimit(id));
    }
}
