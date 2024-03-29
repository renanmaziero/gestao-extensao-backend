package com.ftunicamp.tcc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String matricula;

    private String endereco;

    @OneToMany(mappedBy = "docente", fetch = FetchType.LAZY)
    private List<Atividade> atividades;

    @OneToMany(mappedBy = "docente", fetch = FetchType.LAZY)
    private List<Alocacao> alocacao;

    @OneToOne
    private UsuarioEntity user;

    private String email;

    private String telefone;

    private boolean admin;

    private boolean autorizado;

    @Enumerated(EnumType.STRING)
    private Titulo titulo;
}