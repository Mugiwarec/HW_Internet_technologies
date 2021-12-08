package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.OverLimit;
import com.mugiwarec.core.entity.OverLimitEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OverLimitMapper {

    OverLimitMapper MAPPER = Mappers.getMapper(OverLimitMapper.class);

    OverLimit toOverLimit(OverLimitEntity entity);

    OverLimitEntity toOverLimitEntity(OverLimit model);
}
