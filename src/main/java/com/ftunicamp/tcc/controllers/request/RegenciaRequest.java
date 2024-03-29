package com.ftunicamp.tcc.controllers.request;

import com.ftunicamp.tcc.dto.AlocacaoDto;
import com.ftunicamp.tcc.model.Nivel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RegenciaRequest {
    private Nivel nivel;
    private String curso;
    private String coordenador;
    private String disciplinaParticipacao;
    private int totalHorasMinistradas;
    private int totalHorasOutrasAtividades;
    private Double valorBrutoHora = 0.0;
    private Double valorBrutoTotal = 0.0;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private int horaSemanal;
    private int horaMensal;
    private String observacao;
    private String instituicao;
    private String diasTrabalhadosUnicamp;
    private String diasTrabalhadosOutraInstituicao;
    private boolean responsavel;
    private boolean unicoDocente;
    private List<AlocacaoDto> alocacoes;
    private boolean urgente;
    private boolean excedeu;

}
