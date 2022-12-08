package com.ftunicamp.tcc.service.impl;

import com.ftunicamp.tcc.controllers.response.ParametrizacaoResponse;
import com.ftunicamp.tcc.dto.ParametrizacaoDto;
import com.ftunicamp.tcc.model.Parametrizacao;
import com.ftunicamp.tcc.repositories.ParametrizacaoRepository;
import com.ftunicamp.tcc.security.jwt.JwtUtils;
import com.ftunicamp.tcc.service.ParametrizacaoService;
import com.ftunicamp.tcc.utils.AtividadeFactory;
import com.ftunicamp.tcc.utils.ParametrizacaoFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParametrizacaoServiceImpl implements ParametrizacaoService {

    private final JwtUtils jwtUtils;
    private final ParametrizacaoRepository parametrizacaoRepository;

    public ParametrizacaoServiceImpl(JwtUtils jwtUtils, ParametrizacaoRepository parametrizacaoRepository) {
        this.jwtUtils = jwtUtils;
        this.parametrizacaoRepository = parametrizacaoRepository;
    }

    @Override
    public List<ParametrizacaoResponse> listarParametrizacoes() {
        final var sessao = jwtUtils.getSessao();
        final var profiles = sessao.getProfiles();
        final List<ParametrizacaoResponse> parametrizacaoResponse = new ArrayList<>();

        if (profiles.stream().anyMatch(profile -> profile.equalsIgnoreCase("ROLE_ADMIN"))) {
            parametrizacaoRepository.findAll().forEach(parametrizacao -> mapToParametrizacaoResponse(parametrizacaoResponse, parametrizacao));
            return parametrizacaoResponse;
        } else {
            //parametrizacaoRepository.findAllByDocente(sessao.getUsername()).forEach(parametrizacao -> mapToParametrizacaoResponse(parametrizacaoResponse, parametrizacao));
            parametrizacaoRepository.findAll().forEach(parametrizacao -> mapToParametrizacaoResponse(parametrizacaoResponse, parametrizacao));
            return parametrizacaoResponse; //esse retorno é para os docentes na tela de submeter atividade
        }

        //return parametrizacaoResponse;
    }

    @Override
    public void updateParametrizacao(ParametrizacaoDto request) {
        parametrizacaoRepository.findById(request.getId())
                .ifPresentOrElse(parametrizacao -> parametrizacaoRepository.save(ParametrizacaoFactory.updateParametriazcao(request, parametrizacao)), () -> {
                    throw new NoSuchElementException("Parametrização não encontrada");
                });

    }

    private void mapToParametrizacaoResponse(List<ParametrizacaoResponse> parametrizacaoResponse, Parametrizacao parametrizacao) {
        var response = ParametrizacaoResponse.builder()
                .id(parametrizacao.getId())
                .max_hr_semanais_convenio(parametrizacao.getMax_hr_semanais_convenio())
                .max_hr_mensais_convenio(parametrizacao.getMax_hr_mensais_convenio())
                .max_hr_semestrais_convenio(parametrizacao.getMax_hr_semestrais_convenio())
                .max_hr_ministradas_curso(parametrizacao.getMax_hr_ministradas_curso())
                .max_hr_semestrais_curso(parametrizacao.getMax_hr_semestrais_curso())
                .max_hr_semestrais_regencia(parametrizacao.getMax_hr_semestrais_regencia())
                .build();
        parametrizacaoResponse.add(response);
    }
}
