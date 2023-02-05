package com.ftunicamp.tcc.service.impl;

import com.ftunicamp.tcc.repositories.ConsultaAlocacaoRepository;
import com.ftunicamp.tcc.service.ConsultaAlocacaoService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaAlocacaoServiceImpl implements ConsultaAlocacaoService {
    private final ConsultaAlocacaoRepository consultaAlocacaoRepository;

    public ConsultaAlocacaoServiceImpl(ConsultaAlocacaoRepository consultaAlocacaoRepository) {
        this.consultaAlocacaoRepository = consultaAlocacaoRepository;
    }

    @Override
    public int[] totalHorasAprovadas(Long docenteId) {
        var totais = new int[]{0, 0, 0};
        totais[0] = consultaAlocacaoRepository.totalHorasConvenio(docenteId);
        totais[1] = consultaAlocacaoRepository.totalHorasCurso(docenteId);
        totais[2] = consultaAlocacaoRepository.totalHorasRegencia(docenteId);
        return totais;
    }
}
