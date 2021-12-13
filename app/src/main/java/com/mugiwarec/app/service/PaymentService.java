package com.mugiwarec.app.service;

import com.mugiwarec.app.model.Payment;

import java.util.Optional;

public interface PaymentService {

    Optional<Payment> findPaymentById(Long id);

    Payment savePayment(Payment payment);

    Payment updatePayment(Payment payment);

    String deletePayment(Long id);
}
