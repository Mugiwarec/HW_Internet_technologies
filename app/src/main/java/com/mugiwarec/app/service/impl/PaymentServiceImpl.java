package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.PaymentMapper;
import com.mugiwarec.app.model.Payment;
import com.mugiwarec.app.service.PaymentService;
import com.mugiwarec.core.entity.PaymentEntity;
import com.mugiwarec.core.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository repository;

    @Override
    public Optional<Payment> findPaymentById(Long id) {
        return repository.findById(id).map(PaymentMapper.MAPPER::toPayment);
    }

    @Override
    public Payment savePayment(Payment payment) {
        PaymentEntity entity = repository.saveAndFlush(PaymentMapper.MAPPER.toPaymentEntity(payment));

        return PaymentMapper.MAPPER.toPayment(entity);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        Optional<PaymentEntity> entity = repository.findById(payment.getId());

        if (entity.isPresent()) {
            repository.saveAndFlush(PaymentMapper.MAPPER.toPaymentEntity(payment));
        } else {
            throw new RuntimeException("Payment not found");
        }

        return payment;
    }

    @Override
    public String deletePayment(Long id) {
        Optional<PaymentEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Payment not found");
        }

        return "Payment was deleted";
    }
}
