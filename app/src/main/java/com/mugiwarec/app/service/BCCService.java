package com.mugiwarec.app.service;

import com.mugiwarec.app.model.BCC;

import java.util.Optional;

public interface BCCService {

    Optional<BCC> findBCCById(Long id);

    BCC saveBCC(BCC bcc);

    BCC updateBCC(BCC bcc);

    String deleteBCC(Long id);
}
