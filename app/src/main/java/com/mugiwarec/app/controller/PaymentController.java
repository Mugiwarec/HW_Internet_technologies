package com.mugiwarec.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugiwarec.app.model.Payment;
import com.mugiwarec.app.service.PaymentService;
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
@RequestMapping(value = "/api/v1/payment",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
public class PaymentController {

    private final PaymentService service;

    private final ObjectMapper mapper;

    @GetMapping("/read/{id}")
    public ResponseEntity<Payment> findPaymentById(@PathVariable @Positive Long id) {
        return ResponseEntity.of(service.findPaymentById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@Valid @NotNull @RequestBody Payment payment) {
        return ResponseEntity.ok(service.savePayment(payment));
    }

    @PutMapping("/update")
    public ResponseEntity<Payment> updatePayment(@Valid @NotNull @RequestBody Payment payment) {
        return ResponseEntity.ok(service.updatePayment(payment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.deletePayment(id));
    }
}
