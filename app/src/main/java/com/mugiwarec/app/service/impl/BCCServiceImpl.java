package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.BCCMapper;
import com.mugiwarec.app.model.BCC;
import com.mugiwarec.app.service.BCCService;
import com.mugiwarec.core.entity.BCCEntity;
import com.mugiwarec.core.repository.BCCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BCCServiceImpl implements BCCService {

    private final BCCRepository repository;

    @Override
    public Optional<BCC> findBCCById(Long id) {
        return repository.findById(id).map(BCCMapper.MAPPER::toBCC);
    }

    @Override
    public BCC saveBCC(BCC bcc) {
        BCCEntity entity = repository.saveAndFlush(BCCMapper.MAPPER.toBCCEntity(bcc));

        return BCCMapper.MAPPER.toBCC(entity);
    }

    @Override
    public BCC updateBCC(BCC bcc) {
        Optional<BCCEntity> entity = repository.findById(bcc.getId());

        if (entity.isPresent()) {
            repository.saveAndFlush(BCCMapper.MAPPER.toBCCEntity(bcc));
        } else {
            throw new RuntimeException("BCC not Found");
        }

        return bcc;
    }

    @Override
    public String deleteBCC(Long id) {
        Optional<BCCEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("BCC not Found");
        }

        return "BCC was deleted";
    }
}
