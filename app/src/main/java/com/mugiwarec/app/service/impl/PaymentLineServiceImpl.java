package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.PaymentLineMapper;
import com.mugiwarec.app.model.PaymentLine;
import com.mugiwarec.app.service.PaymentLineService;
import com.mugiwarec.core.entity.PaymentLineEntity;
import com.mugiwarec.core.repository.PaymentLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentLineServiceImpl implements PaymentLineService {

    private PaymentLineRepository repository;

    @Override
    public Optional<PaymentLine> findPaymentLineById(Long id) {
        return repository.findById(id).map(PaymentLineMapper.MAPPER::toPaymentLine);
    }

    @Override
    public PaymentLine savePaymentLine(PaymentLine paymentLine) {
        PaymentLineEntity entity = repository.saveAndFlush(PaymentLineMapper.MAPPER.toPaymentLineEntity(paymentLine));

        return PaymentLineMapper.MAPPER.toPaymentLine(entity);
    }

    @Override
    public PaymentLine updatePaymentLine(PaymentLine paymentLine) {
        Optional<PaymentLineEntity> entity = repository.findById(paymentLine.getId());

        if (entity.isPresent()) {
            repository.saveAndFlush(PaymentLineMapper.MAPPER.toPaymentLineEntity(paymentLine));
        } else {
            throw new RuntimeException("PaymentLine not found");
        }

        return null;
    }

    @Override
    public String deletePaymentLine(Long id) {
        Optional<PaymentLineEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("PaymentLine not found");
        }

        return "PaymentLine was deleted";
    }
}
