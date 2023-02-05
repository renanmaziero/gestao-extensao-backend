package com.ftunicamp.tcc.repositories;

import com.ftunicamp.tcc.model.Alocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaAlocacaoRepository extends JpaRepository<Alocacao, Long> {
    @Query(value = "select sum(total_horas_aprovadas) " +
            "from alocacao " +
            "where atividade_id " +
            "in " +
            "(select id " +
            "from atividade " +
            "where tipo_atividade " +
            "like 'convenio') " +
            "and docente_id = ?1", nativeQuery = true)
    int totalHorasConvenio(Long docenteId);

    @Query(value = "select sum(total_horas_aprovadas) " +
            "from alocacao " +
            "where atividade_id " +
            "in " +
            "(select id " +
            "from atividade " +
            "where tipo_atividade " +
            "like 'curso') " +
            "and docente_id = ?1", nativeQuery = true)
    int totalHorasCurso(Long docenteId);

    @Query(value = "select sum(total_horas_aprovadas) " +
            "from alocacao " +
            "where atividade_id " +
            "in " +
            "(select id " +
            "from atividade " +
            "where tipo_atividade " +
            "like 'regencia') " +
            "and docente_id = ?1", nativeQuery = true)
    int totalHorasRegencia(Long docenteId);

}
