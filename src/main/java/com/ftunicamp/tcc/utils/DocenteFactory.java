package com.ftunicamp.tcc.utils;

import com.ftunicamp.tcc.controllers.request.SignUpRequest;
import com.ftunicamp.tcc.model.Docente;
import com.ftunicamp.tcc.model.Titulo;
import com.ftunicamp.tcc.model.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class DocenteFactory {

    private DocenteFactory() {
    }

    public static Docente criarDocente(SignUpRequest request, UsuarioEntity user) {

        var docente = new Docente();
        docente.setNome(request.getNome());
        docente.setCpf(request.getCpf().replaceAll("[^0-9]",""));
        docente.setEmail(request.getEmail());
        docente.setEndereco(request.getEndereco());
        docente.setMatricula(request.getRf());
        docente.setTelefone(request.getTelefone().replaceAll("[^0-9]",""));
        docente.setUser(user);
        docente.setTitulo(Titulo.fromString(request.getTitulo()));

        return docente;
    }
}
