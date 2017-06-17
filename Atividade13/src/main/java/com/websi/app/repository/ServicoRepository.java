package com.websi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.websi.app.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
