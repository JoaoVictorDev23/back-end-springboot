package com.tdm.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.helpdesk.domain.Tarifa;
import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.domain.dtos.TarifaDTO;
import com.tdm.helpdesk.domain.enums.Status;
import com.tdm.helpdesk.repositories.TarifaRepository;
import com.tdm.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TarifaService {
	
	@Autowired 
	private TarifaRepository repository;
	@Autowired
	private USUARIOService usuarioservice;
	
	
	
	public Tarifa findById(Integer id) {
		Optional<Tarifa> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! ID:" +id ));
	}


	public List<Tarifa> findAll() {
		return repository.findAll();
	}


	public Tarifa create(@Valid TarifaDTO objDTO) {
		
		return repository.save(newTarifa(objDTO));
	}
	
	private Tarifa newTarifa(TarifaDTO obj) {
		USUARIO usuario = usuarioservice.findById(obj.getUsuario());
		
		
		Tarifa tarifa = new Tarifa();
		if(obj.getId() !=null ) {
			tarifa.setId(obj.getId());
		}
		tarifa.setUsuario(usuario);
		tarifa.setStatus(Status.toEnum(obj.getStatus()));
		tarifa.setInicioRota(obj.getInicioRota());
		tarifa.setFimRota(obj.getFimRota());
		tarifa.setObservação(obj.getObservação());
		tarifa.setValorTarifa(obj.getValorTarifa());
		return tarifa;
		
		
	}

}
