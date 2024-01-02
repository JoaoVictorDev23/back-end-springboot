package com.tdm.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.repositories.UsuarioRepository;

@Service
public class USUARIOService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public USUARIO findById(Integer id) {
		
		Optional<USUARIO> obj = repository.findById(id);
		return obj.orElse(null);
		
	}
}