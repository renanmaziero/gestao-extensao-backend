package com.ftunicamp.tcc.service;

import com.ftunicamp.tcc.controllers.response.ParametrizacaoResponse;
import com.ftunicamp.tcc.dto.CursoExtensaoDto;
import com.ftunicamp.tcc.dto.ParametrizacaoDto;

import java.util.List;

public interface ParametrizacaoService {
    List<ParametrizacaoResponse> listarParametrizacoes();
    void updateParametrizacao(ParametrizacaoDto parametrizacaoDto);
}
