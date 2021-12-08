package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.BCC;
import com.mugiwarec.core.entity.BCCEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BCCMapper {

    BCCMapper MAPPER = Mappers.getMapper(BCCMapper.class);

    @Mapping(target = "overLimits", source = "entity.overLimitEntities")
    BCC toBCC(BCCEntity entity);

    @Mapping(target = "overLimitEntities", source = "model.overLimits")
    BCCEntity toBCCEntity(BCC model);
}
