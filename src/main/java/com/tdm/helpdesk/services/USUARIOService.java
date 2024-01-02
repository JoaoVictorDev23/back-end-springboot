package com.tdm.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.domain.dtos.USUARIODTO;
import com.tdm.helpdesk.repositories.UsuarioRepository;
import com.tdm.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class USUARIOService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public USUARIO findById(Integer id) {
		
		Optional<USUARIO> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! ID: "+ id));
		
	}
	
	public List<USUARIO> findAll(){
		return repository.findAll();
	}

	public USUARIO create(USUARIODTO objDTO) {
		
		objDTO.setId(null);
		USUARIO newObj = new USUARIO(objDTO);
		return repository.save(newObj);
	}
}
