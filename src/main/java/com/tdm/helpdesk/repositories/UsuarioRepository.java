package com.tdm.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tdm.helpdesk.domain.USUARIO;

public interface UsuarioRepository extends JpaRepository<USUARIO, Integer>{

}
