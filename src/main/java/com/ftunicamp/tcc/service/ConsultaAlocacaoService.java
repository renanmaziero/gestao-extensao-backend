package com.ftunicamp.tcc.service;

public interface ConsultaAlocacaoService {
    int[] totalHorasAprovadas(Long docenteId);

    int[] consultarAlocacoes(Long docenteId, Integer semestre, Integer ano);
}
