package com.mugiwarec.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugiwarec.app.model.PaymentLine;
import com.mugiwarec.app.service.PaymentLineService;
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
@RequestMapping(value = "/api/v1/payment_line",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
public class PaymentLineController {

    private final PaymentLineService service;

    private final ObjectMapper mapper;

    @GetMapping("/read/{id}")
    public ResponseEntity<PaymentLine> findPaymentLineById(@PathVariable @Positive Long id) {
        return ResponseEntity.of(service.findPaymentLineById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentLine> createPayment(@Valid @NotNull @RequestBody PaymentLine paymentLine) {
        return ResponseEntity.ok(service.savePaymentLine(paymentLine));
    }

    @PutMapping("/update")
    public ResponseEntity<PaymentLine> updatePayment(@Valid @NotNull @RequestBody PaymentLine paymentLine) {
        return ResponseEntity.ok(service.updatePaymentLine(paymentLine));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(service.deletePaymentLine(id));
    }
}
