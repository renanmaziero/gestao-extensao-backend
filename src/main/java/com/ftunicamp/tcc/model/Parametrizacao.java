package com.ftunicamp.tcc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data //@Getter, @Setter, etc. tudo junto
@Entity
public class Parametrizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column
    private int max_hr_semanais_convenio;

    @Column
    private int max_hr_mensais_convenio;

    @Column
    private int max_hr_semestrais_convenio;

    @Column
    private int max_hr_ministradas_curso;

    @Column
    private int max_hr_semestrais_curso;

    @Column
    private int max_hr_semestrais_regencia;
}
