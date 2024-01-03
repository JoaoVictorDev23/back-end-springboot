package com.tdm.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdm.helpdesk.domain.Tarifa;
import com.tdm.helpdesk.domain.dtos.TarifaDTO;
import com.tdm.helpdesk.services.TarifaService;

@RestController
@RequestMapping(value ="/tarifas")
public class TarifaResource {
	
	@Autowired
	private TarifaService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<TarifaDTO> findById(@PathVariable Integer id){
		Tarifa obj = service.findById(id);
		return ResponseEntity.ok().body(new TarifaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TarifaDTO>> findAll(){
		List<Tarifa> list = service.findAll();
		List<TarifaDTO> listDTO = list.stream().map(obj -> new TarifaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}

}
