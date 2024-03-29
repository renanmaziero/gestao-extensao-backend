package com.ftunicamp.tcc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConvenioDto {
    private String descricao;
    private String instituicao;
    private String tipoAtividadeSimultanea;
    private String coordenador;
    private long id;
    private String projeto;
    private Double valorBruto;
    private String docente;
    private int horaMensal;
    private int horaSemanal;
    private long prazo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String observacao;
    private boolean autorizado;
    private String tipoAtividade;
    private String revisao;
    private List<AlocacaoDto> alocacoes;
    private boolean excedido;
    private boolean urgente;
    private boolean excedeu;
}
