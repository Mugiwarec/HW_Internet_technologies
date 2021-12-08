package com.mugiwarec.app.service;

import com.mugiwarec.app.model.OverLimit;

import java.util.Optional;

public interface OverLimitService {

    Optional<OverLimit> findOverLimitById(Long id);

    OverLimit saveOverLimit(OverLimit overLimit);

    OverLimit updateOverLimit(OverLimit overLimit);

    String deleteOverLimit(Long id);
}
