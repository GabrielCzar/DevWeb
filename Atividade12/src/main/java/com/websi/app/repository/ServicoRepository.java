package com.websi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.websi.app.model.Servico;

@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
