package com.ftunicamp.tcc.controllers;

import com.ftunicamp.tcc.controllers.response.ParametrizacaoResponse;
import com.ftunicamp.tcc.dto.CursoExtensaoDto;
import com.ftunicamp.tcc.dto.ParametrizacaoDto;
import com.ftunicamp.tcc.service.ParametrizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parametrizacao")

public class ParametrizacaoController {
    @Autowired
    private ParametrizacaoService parametrizacaoService;

    @GetMapping("/all")
    public ResponseEntity<List<ParametrizacaoResponse>> getParametrizacao() {
        return ResponseEntity.ok(parametrizacaoService.listarParametrizacoes());
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCursoExtensao(@RequestBody ParametrizacaoDto parametrizacaoDto) {
        parametrizacaoService.updateParametrizacao(parametrizacaoDto);
        return ResponseEntity.ok().build();
    }
}
