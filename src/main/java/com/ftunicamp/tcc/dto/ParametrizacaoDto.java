package com.ftunicamp.tcc.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParametrizacaoDto {

    private long id;

    private int max_hr_semanais_convenio;


    private int max_hr_mensais_convenio;


    private int max_hr_semestrais_convenio;


    private int max_hr_ministradas_curso;


    private int max_hr_semestrais_curso;


    private int max_hr_semestrais_regencia;
}
