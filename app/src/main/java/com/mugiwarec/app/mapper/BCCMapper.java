package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.BCC;
import com.mugiwarec.core.entity.BCCEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BCCMapper {

    BCCMapper MAPPER = Mappers.getMapper(BCCMapper.class);

    BCC toBCC(BCCEntity entity);

    BCCEntity toBCCEntity(BCC model);
}
