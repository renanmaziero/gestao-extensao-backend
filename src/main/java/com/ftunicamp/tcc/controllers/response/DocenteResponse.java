package com.ftunicamp.tcc.controllers.response;

import com.ftunicamp.tcc.model.Titulo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocenteResponse {

    private long id;
    private String matricula;
    private String nome;
    private String email;
    private Titulo titulo;
    private Boolean autorizado;
    private String telefone;
    private boolean admin;
    private long totalHoras;
    private long totalHorasAprovadas;
    private long totalHorasSolicitadas;
}
