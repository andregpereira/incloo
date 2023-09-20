package com.andregpereira.challenges.incloo.inclooapi.domain.usecase.vaga;

import com.andregpereira.challenges.incloo.inclooapi.domain.gateway.VagaGateway;
import com.andregpereira.challenges.incloo.inclooapi.domain.model.Vaga;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Component
public non-sealed class VagaFindByMinorityGroupsUcImpl implements VagaFindByMinorityGroupsUc {

    private final VagaGateway gateway;

    @Override
    public Page<Vaga> findByPublicosAlvos(Set<String> publicosAlvos, Pageable pageable) {
        return gateway.findByPublicosAlvos(publicosAlvos, pageable);
    }

}
