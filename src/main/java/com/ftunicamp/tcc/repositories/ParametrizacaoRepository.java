package com.ftunicamp.tcc.repositories;

import com.ftunicamp.tcc.model.Parametrizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ParametrizacaoRepository extends JpaRepository<Parametrizacao, Long> {

}
