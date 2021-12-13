package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.OverLimitMapper;
import com.mugiwarec.app.model.OverLimit;
import com.mugiwarec.app.service.OverLimitService;
import com.mugiwarec.core.entity.OverLimitEntity;
import com.mugiwarec.core.repository.OverLimitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OverLimitServiceImpl implements OverLimitService {

    private OverLimitRepository repository;

    @Override
    public Optional<OverLimit> findOverLimitById(Long id) {
        return repository.findById(id).map(OverLimitMapper.MAPPER::toOverLimit);
    }

    @Override
    public OverLimit saveOverLimit(OverLimit overLimit) {
        OverLimitEntity entity = repository.saveAndFlush(OverLimitMapper.MAPPER.toOverLimitEntity(overLimit));

        return OverLimitMapper.MAPPER.toOverLimit(entity);
    }

    @Override
    public OverLimit updateOverLimit(OverLimit overLimit) {
        Optional<OverLimitEntity> entity = repository.findById(overLimit.getId());

        if (entity.isPresent()) {
            repository.saveAndFlush(OverLimitMapper.MAPPER.toOverLimitEntity(overLimit));
        } else {
            throw new RuntimeException("OverLimit not found");
        }

        return overLimit;
    }

    @Override
    public String deleteOverLimit(Long id) {
        Optional<OverLimitEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("OverLimit not found");
        }

        return "OverLimit was deleted";
    }
}
