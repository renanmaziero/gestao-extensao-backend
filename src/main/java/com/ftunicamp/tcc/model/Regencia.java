package com.ftunicamp.tcc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "regencia")
@DiscriminatorValue("regencia")
public class Regencia extends Atividade {

    private String instituicao;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    private String curso;

    private String disciplinaParticipacao;

    private boolean responsavel;

    private boolean unicoDocente;

    private String diasTrabalhadosUnicamp;

    private String diasTrabalhadosOutraInstituicao;

    private int totalHorasMinistradas;

    private int totalHorasOutrasAtividades;

    private Double valorBrutoHora = 0.0;

    private Double valorBrutoTotal = 0.0;

}
