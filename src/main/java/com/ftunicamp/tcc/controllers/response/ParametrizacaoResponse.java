package com.ftunicamp.tcc.controllers.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ParametrizacaoResponse implements Serializable {
    private long id;
    private String max_hr_mensais_convenio;
    private String max_hr_ministradas_curso;
    private String max_hr_semanais_convenio;
    private String max_hr_semestrais_convenio;
    private String max_hr_semestrais_curso;
    private String max_hr_semestrais_regencia;

}
