package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.PaymentLine;
import com.mugiwarec.core.entity.PaymentLineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentLineMapper {

    PaymentLineMapper MAPPER = Mappers.getMapper(PaymentLineMapper.class);

    PaymentLine toPaymentLine(PaymentLineEntity entity);

    PaymentLineEntity toPaymentLineEntity(PaymentLine model);
}
