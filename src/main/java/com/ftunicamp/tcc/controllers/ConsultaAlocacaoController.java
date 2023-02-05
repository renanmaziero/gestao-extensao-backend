package com.ftunicamp.tcc.controllers;

import com.ftunicamp.tcc.service.ConsultaAlocacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/alocacao")
@AllArgsConstructor
public class ConsultaAlocacaoController {
    @Autowired
    private ConsultaAlocacaoService consultaAlocacaoService;

    @GetMapping("consultar/{id}")
    public int[] totalHorasAprovadas(@PathVariable("id") Long docenteId){
        return consultaAlocacaoService.totalHorasAprovadas(docenteId);
    }
}