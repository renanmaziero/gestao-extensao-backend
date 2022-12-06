package com.ftunicamp.tcc.utils;

import com.ftunicamp.tcc.controllers.request.Participacao;
import com.ftunicamp.tcc.dto.CursoExtensaoDto;
import com.ftunicamp.tcc.dto.ParametrizacaoDto;
import com.ftunicamp.tcc.model.CursoExtensao;
import com.ftunicamp.tcc.model.Parametrizacao;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

@Component
public class ParametrizacaoFactory {
    public static Parametrizacao updateParametriazcao(ParametrizacaoDto request, Parametrizacao parametrizacao) {
        System.out.print(request);
        System.out.print(parametrizacao);
        parametrizacao.setMax_hr_ministradas_curso(request.getMax_hr_ministradas_curso());
        parametrizacao.setMax_hr_semestrais_curso(request.getMax_hr_semestrais_curso());
        parametrizacao.setMax_hr_semestrais_convenio(request.getMax_hr_semestrais_convenio());
        parametrizacao.setMax_hr_mensais_convenio(request.getMax_hr_mensais_convenio());
        parametrizacao.setMax_hr_semanais_convenio(request.getMax_hr_semanais_convenio());
        parametrizacao.setMax_hr_semestrais_regencia(request.getMax_hr_semestrais_regencia());

        return parametrizacao;
    }
}
