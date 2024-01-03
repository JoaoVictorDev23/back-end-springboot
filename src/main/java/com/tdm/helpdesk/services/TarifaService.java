package com.tdm.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.helpdesk.domain.Tarifa;
import com.tdm.helpdesk.repositories.TarifaRepository;
import com.tdm.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TarifaService {
	
	@Autowired 
	private TarifaRepository repository;
	
	
	public Tarifa findById(Integer id) {
		Optional<Tarifa> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! ID:" +id ));
	}


	public List<Tarifa> findAll() {
		return repository.findAll();
	}

}
