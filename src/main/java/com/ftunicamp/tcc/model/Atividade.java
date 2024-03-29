package com.ftunicamp.tcc.model;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Named;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_ATIVIDADE")
@Named("Atividade")
public abstract class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projeto;

    private Double valorBruto;

    private String coordenador;

    @ManyToOne(fetch = FetchType.EAGER)
    private Docente docente;

    private Integer horaMensal;

    private Integer horaSemanal;

    private long prazo;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    private LocalDate dataCriacao;

    private LocalDate dataModificacao;

    private boolean urgente;

    @Enumerated(EnumType.STRING)
    private StatusAtividade status = StatusAtividade.PENDENTE;

    private String observacao;

    private String revisao;

    @Column(columnDefinition = "boolean default false")
    private boolean excedeu;

    @OneToMany(mappedBy = "atividade", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Alocacao> alocacao;

    @OneToOne(mappedBy = "atividade", fetch = FetchType.LAZY)
    private Autorizacao autorizacao;

    @Transient
    private String tipo = getTipoAtividade();

    @Transient
    public String getTipoAtividade() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value().toUpperCase();
    }
}
