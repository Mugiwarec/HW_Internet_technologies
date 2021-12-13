package com.mugiwarec.app.service;

import com.mugiwarec.app.model.PaymentLine;

import java.util.Optional;

public interface PaymentLineService {

    Optional<PaymentLine> findPaymentLineById(Long id);

    PaymentLine savePaymentLine(PaymentLine paymentLine);

    PaymentLine updatePaymentLine(PaymentLine paymentLine);

    String deletePaymentLine(Long id);
}
