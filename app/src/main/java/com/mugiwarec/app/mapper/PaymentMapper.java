package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.Payment;
import com.mugiwarec.core.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper MAPPER = Mappers.getMapper(PaymentMapper.class);

    @Mapping(target = "paymentLines", source = "entity.paymentLineEntities")
    Payment toPayment(PaymentEntity entity);

    @Mapping(target = "paymentLineEntities", source = "model.paymentLines")
    PaymentEntity toPaymentEntity(Payment model);
}
