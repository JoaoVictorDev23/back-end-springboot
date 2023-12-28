package com.tdm.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdm.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
